# 네이버 신지도 데이터 수집하기
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import requests
from bs4 import BeautifulSoup

browser = webdriver.Chrome("./chromedriver")
browser.maximize_window()

URL = "https://map.naver.com/v5/search"
browser.get(URL)


# # 팝업 창 제거
# driver.find_element_by_css_selector("button#intro_popup_close").click()

# 시간 지연
time.sleep(2)

# 검색창에 검색어 입력하기
search_box = browser.find_element_by_css_selector(
    ".panel_wrap .search_box .input_box .input_search")
search_box.send_keys("마포구 필라테스")

# 검색 버튼 누르기
search_box.send_keys(Keys.RETURN)


print("검색완료")

# 시간 지연
time.sleep(2)

# 크롤링
html = browser.page_source
soup = BeautifulSoup(html, "html.parser")

element = browser.find_element_by_id("searchIframe")
browser.switch_to.frame(element)

place_title = soup.find_all("span")

print(place_title)
