from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
from bs4 import BeautifulSoup

# 크롬드라이버 로드
browser = webdriver.Chrome("../chromedriver")
browser.maximize_window()

# 페이지이동
URL = "https://map.naver.com/v5/search/"
browser.get(URL)

# 시간 지연
time.sleep(2)

# 검색창에 검색어 입력하기
search = browser.find_element_by_css_selector(
    ".panel_wrap .search_box .input_box .input_search")
search.send_keys("마포구 필라테스")
search.send_keys(Keys.RETURN)

# 검색 버튼 누르기
search.send_keys(Keys.RETURN)
print("검색완료")

# 시간 지연
time.sleep(2)

# 처음 화면
html = browser.page_source
soup = BeautifulSoup(html, "lxml")


# 업체리스트 Iframe 진입
search_iframe = browser.switch_to.frame("searchIframe")

browser.find_element_by_class_name("_3Apve").click()
print("타이틀 클릭 완료")

# 시간 지연
time.sleep(3)

#  장소 상세 Ifram 진입
browser.switch_to.default_content()  # 처음 상태로 돌아오기
place_info = browser.switch_to.frame('entryIframe')
print("장소 상세 진입")

# 크롤링
html
soup

place_info_list = []
for item in place_info:
    temp = []
    title = place_info.find_all(
        "span", attrs={"class": "_3XamX"}).get_text()  # 업체명
    phone_num = place_info.find_all("span", {"class": "_3ZA0S"})  # 전화번호
    address = place_info.find_all("span", {"class": "_2yqUQ"})  # 주소
    hours = place_info.find_all("div", {"class": "_2ZP3j "})  # 영업시간
    info = place_info.find_all("div", {"class": "_1h3B_"})  # 시설정보
    introduction = ("span", {"class": "WoYOw"})  # 업체소개
    # place_photo = #업체사진
    print(title)

# 더이상 누를게 없을때 브레이크
# 다시 페이징으로 진입
