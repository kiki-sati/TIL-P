from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import requests
from bs4 import BeautifulSoup

# 크롬드라이버 로드
browser = webdriver.Chrome("./chromedriver")
browser.maximize_window()

URL = "https://map.naver.com/v5/search/"
browser.get(URL)

# 시간 지연
time.sleep(2)

# 검색창에 검색어 입력하기
search_box = browser.find_element_by_css_selector(
    ".panel_wrap .search_box .input_box .input_search")
search_box.send_keys("마포구 필라테스")
search_box.send_keys(Keys.RETURN)

# 검색 버튼 누르기
search_box.send_keys(Keys.RETURN)
print("검색완료")

# 시간 지연
time.sleep(2)

# 처음 화면
html = browser.page_source
soup = BeautifulSoup(html, "lxml")

# 1번째 Iframe 들어가기
browser.switch_to.frame("searchIframe")

html = browser.page_source
soup = BeautifulSoup(html, "lxml")

# TEST -> ok
place_title = soup.find_all("span", {"class": "_3Apve"})
print(place_title)
