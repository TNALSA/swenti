from bs4 import BeautifulSoup

import news_dao
import requests
url = "https://news.naver.com/section/105"
headers = {
    "User-Agent":"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36",
    "Accept-Language":"ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7",
    "Accept":"text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7"
}
res = requests.get(url, headers=headers)
res.raise_for_status()

soup = BeautifulSoup(res.text, "lxml")

news_list = soup.find("ul", attrs={"class" : "sa_list"}).find_all("li")
for news in news_list:
    title = news.find("div",attrs={"class" : "sa_text"}).find("a").get_text().strip()
    link = news.find("div",attrs={"class" : "sa_text"}).find("a")["href"]
    publisher = news.find("div",attrs={"class" : "sa_text"}).find("div",attrs={"class" : "sa_text_press"}).get_text().strip()
    image = news.find("div", attrs={"class" : "sa_thumb_inner"}).find("img",attrs={"class" : "_LAZY_LOADING _LAZY_LOADING_INIT_HIDE"})

    if image and "data-src" in image.attrs:
        image_url = image["data-src"]
    else:
        image_url = "이미지가 존재하지 않습니다."

    print("기사 제목: "+title)
    print("링크: "+link)
    print("언론사: "+publisher)
    print("이미지: "+image_url)
    print("-----")

    news_dao.insert_article(title=title, link=link, publisher=publisher, image=image_url, site="네이버")