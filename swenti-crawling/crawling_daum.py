import datetime
import json
import time

from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.wait import WebDriverWait

import article_dao
import requests

url = "https://news.daum.net/digital#1"
headers = {
    "User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36",
    "Accept-Language":"ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7",
    "Accept":"text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"
}

def createSoup(url):
    res = requests.get(url, headers=headers)
    res.raise_for_status()

    soup = BeautifulSoup(res.text, "lxml")
    return soup

def crawledPages():
    options = webdriver.ChromeOptions()
    # 웹 브라우저 안띄우기
    options.add_argument("headless")

    browser = webdriver.Chrome(options=options)
    browser.get(url)
    time.sleep(1)

    # 우선 10초 대기 -> 해당 element가 출력되면 동작하도록 하는 옵션 (from selenium.webdriver.support import expected_conditions as EC -> 모듈 필요)
    # search_result = WebDriverWait(browser, 10).until(
    #     EC.element_to_be_clickable((By.CLASS_NAME, "select-options-wrap"))
    # )

    pages = len(browser.find_element(By.XPATH,"//*[@id='timeline']/div/div").find_elements(By.TAG_NAME,"a"))

    for page in range(1, pages+1):
        page_url = "https://news.daum.net/digital#"+str(page)
        browser.get(page_url)
        articles = browser.find_element(By.XPATH,"//*[@id='timeline']/ul").find_elements(By.TAG_NAME,"li")
        for article in articles:
            link = article.find_element(By.TAG_NAME,"a").get_attribute("href")
            media = article.find_element(By.TAG_NAME, "span").text

            # 기사 별 soup 객체 생성
            article_soup = createSoup(link)
            # 사진 캡션 지우기
            if article_soup.find("article",attrs={"class":"box_view"}).find("figcaption"):
                article_soup.find("article",attrs={"class":"box_view"}).find("figcaption").decompose()

            # 제목
            title = article_soup.find("article",attrs={"class":"box_view"}).find("h3").get_text().strip()

            # 작성자
            if len(article_soup.find("article",attrs={"class":"box_view"}).find("div",attrs={"class":"info_view"}).find_all("span")) > 2:
                writer = article_soup.find("article",attrs={"class":"box_view"}).find("div",attrs={"class":"info_view"}).find("span").get_text().strip()
            else:
                writer = ""

            # 작성일
            writed_date = article_soup.find("article",attrs={"class":"box_view"}).find("div").find("span",attrs={"class":"num_date"}).get_text().strip()
            mod_date = writed_date.split(". ")
            form_date = formattedDate(mod_date)

            # 내용
            details = article_soup.find("article",attrs={"class":"box_view"}).find("div", attrs={"class":"article_view"}).find("section").get_text().strip()

            #이미지
            images = article_soup.find("article",attrs={"class":"box_view"}).find_all("img")
            image_url = []
            for image in images:
                if image["src"]:
                    image_url.append(image["src"])
                else:
                    continue
            image_dict = {f"image{i+1}": value for i, value in enumerate(image_url)}
            json_data = json.dumps(image_dict, indent=4)

            print("제목:", title)
            print("내용:", details)
            print("링크:", link)
            print("언론사:", media)
            print("이미지:", image_url)
            print("작성자:", writer)
            print("작성일:", form_date)
            print("------------------")

            try:
                article_dao.insert_article(title=title, details=details, link=link, media=media, writer=writer, writed_date=form_date, image=json_data, site="다음")
            except Exception as err:
                print("[Error]" + str(err))
                # 중복된 기사 있을 시 바로 종료 ->
                return 0

def formattedDate(date):
    year = date[0]
    month = date[1]
    day = date[2]
    time = date[3]+":00"
    return f'{year}-0{month}-0{day} {time}'

crawledPages()

