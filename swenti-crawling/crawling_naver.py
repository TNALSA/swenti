import json

from bs4 import BeautifulSoup
import article_dao
import requests
url = "https://news.naver.com/section/105"
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
    soup = createSoup(url)
    articles = soup.find("ul", attrs={"class" : "sa_list"}).find_all("li")
    for article in articles:
        link = article.find("div",attrs={"class" : "sa_text"}).find("a")["href"]

        # 기사 하나하나 마다 soup 객체를 생성
        article_soup = createSoup(link)
        title = article_soup.find("div",attrs={"class" : "media_end_head_title"}).get_text().strip()
        media = article_soup.find("div",attrs={"class" : "media_end_head_top _LAZY_LOADING_WRAP"}).find("img")["title"]
        # writer = article_soup.find("div",attrs={"class" : "media_end_head_journalist"}).find("em").get_text()
        if article_soup.find("div",attrs={"class" : "media_end_head_journalist"}):
            writer = article_soup.find("div",attrs={"class" : "media_end_head_journalist"}).find("em").get_text()
        else:
            writer = "해당 없음"
        
        writed_date = article_soup.find("div",attrs={"class" : "media_end_head_info nv_notrans"})\
                                    .find("div", attrs={"class":"media_end_head_info_datestamp_bunch"})\
                                    .find("span")["data-date-time"]
        details = article_soup.find("article").get_text().strip()
        images = article_soup.find("article").find_all("img")

        image_url = []
        for image in images:
            if image["data-src"]:
                image_url.append(image["data-src"])
            else:
                continue

        image_dict = {f"image {i+1}": value for i, value in enumerate(image_url)}
        json_data = json.dumps(image_dict, indent=4)

        print("기사 제목: "+title)
        print("내용: "+details)
        print("링크: "+link)
        print("언론사: "+media)
        print("작성자: "+writer)
        print("작성일: "+writed_date)
        print("이미지: "+str(image_url))
        print("-----")

        article_dao.insert_article(title=title, details=details, link=link, media=media, writer=writer, writed_date=writed_date, image=json_data, site="네이버")

crawledPages()

        