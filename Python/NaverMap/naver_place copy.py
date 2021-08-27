from indeed import get_last_page
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import requests
from bs4 import BeautifulSoup

# 크롬드라이버 로드
browser = webdriver.Chrome("/Users/kimrumm/Documents/chromedriver")
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
browser.switch_to.frame("searchIframe")

# # # TEST -> ok

# # 페이징 반복 for
# # 반복 while true

# browser.find_element_by_class_name("_3Apve").click()
# print("타이틀 클릭 완료")

# # 시간 지연
# time.sleep(3)

# #  장소 상세 Ifram 진입
# browser.switch_to.default_content()  # 처음 상태로 돌아오기
# browser.switch_to.frame('entryIframe')
# print("장소 상세 진입")

# # 크롤링
# html = browser.page_source
# soup = BeautifulSoup(html, "lxml")

# # 상호명 추출
# place_title = soup.find_all("span", {"class": "_3XamX"})
# print(place_title)

# # 더이상 누를게 없을때 브레이크
# # 다시 페이징으로 진입


def get_last_page():
    # 가져올 페이지 입력
    html = browser.page_source

    # 페이지에 쓸 soup 생성
    soup = BeautifulSoup(html, "lxml")

    # 업체리스트 Iframe 진입
    browser.switch_to.frame("searchIframe")


# 페이징 클릭하기
cur_page = 1
target_crawl_num = 5
while cur_page <= target_crawl_num:
    # bs4 초기화
    soup = BeautifulSoup(html, "lxml")


#  # 찾은거에서 모든 a(링크)를 찾는다.
#  # 찾은 링크를 리스트로 만들어준다.
#     links = pagination.find_all('a')
#     pages = []  # 빈 배열을 만들어주기
#     for link in links[:-1]:  # 어디서부터 어디까지 가져올지 페이지 지정가능
#         ages.append(int(link.string))  # span을 찾은다음 그 안에 있는 string만 가져온다.

#     # 마지막 숫자만 가져오기
#     max_page = pages[-1]
#     return max_page


# def extract_info(last_page):
#     info = []
#     for page in range(last_page):
#         print(f"Srapping Place : page{page}")
#         html = browser.page_source
#         soup = BeautifulSoup(html, "lxml")


# def get_place_info():
#     last_page = get_last_page()
#     info = extract_info(last_page)
#     return info
