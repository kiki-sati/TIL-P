from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import random
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
browser.switch_to.frame("searchIframe")

# # TEST -> ok

# 페이지바 찾기
page_bar = browser.find_elements_by_class_name("_2ky45")[0]
pages = page_bar.find_elements_by_css_selector("a")

page_now = page_bar.find_elements_by_class_name(
    "_2tk2s _5vmWW")[0].text.replace("현재페이지", "").strip()

# 페이지 바 리스트 출력
for page in pages:
    page_num = page.text.strip()
    if page_num in ["이전페이지", "다음페이지"]:
        pass
    elif int(page_num) > int(page_now):
        page.send_keys("\n")
        browser.implicitly_wait(3)
        time.sleep(1+random.uniform(0, 1))


browser.find_element_by_class_name("_3Apve").click()
print("타이틀 클릭 완료")

# 시간 지연
time.sleep(3)

#  장소 상세 Ifram 진입
browser.switch_to.default_content()  # 처음 상태로 돌아오기
browser.switch_to.frame('entryIframe')
print("장소 상세 진입")

# 크롤링
html = browser.page_source
soup = BeautifulSoup(html, "lxml")

# 상호명 추출
place_title = soup.find_all("span", {"class": "_3XamX"})
print(place_title)

# 더이상 누를게 없을때 브레이크
# 다시 페이징으로 진입
