from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
from bs4 import BeautifulSoup
import pandas as pd
import re

# 옵션 생성
options = webdriver.ChromeOptions()
# 창 숨기는 옵션 추가
options.add_argument("headless")

# 크롬드라이버 로드
driver = webdriver.Chrome("../chromedriver",  options=options)
driver.maximize_window()

# 페이지이동
URL = "https://map.naver.com/v5/search/"
driver.get(URL)

# 시간 지연
time.sleep(2)

# 검색창에 검색어 입력하기
search = driver.find_element_by_css_selector(
    ".panel_wrap .search_box .input_box .input_search")
search.send_keys("마포구 필라테스")
search.send_keys(Keys.RETURN)

# 검색 버튼 누르기
search.send_keys(Keys.RETURN)
# print("검색완료")

# 시간 지연
time.sleep(2)

# 처음 화면
html = driver.page_source
soup = BeautifulSoup(html, "lxml")


# 업체리스트 Iframe 진입
search_iframe = driver.switch_to.frame("searchIframe")

driver.find_element_by_class_name("_3Apve").click()
#print("타이틀 클릭 완료")

# 시간 지연
time.sleep(3)

#  장소 상세 Ifram 진입
driver.switch_to.default_content()  # 처음 상태로 돌아오기
driver.switch_to.frame("entryIframe")
#print("장소 상세 진입")

# 더보기를 누르기
btn_more = driver.find_element_by_class_name('_3Dnsh')
btn_more.click()
time.sleep(1)

# 원하는 데이터 수집

dic = {}
for i in ['업체명', '전화번호', '주소', '영업시간', '시설정보', '업체소개']:
    dic[i] = []

data = driver.find_element_by_class_name('place_detail_wrapper')
data = data.text
data_list = data.split('\n')

# 업체명
dic['업체명'].append(data_list[0])

# 전화번호
pn = re.findall(r'\d{2,4}-\d{3,4}-\d{4}', data)
dic['전화번호'].append(pn[0])

# 주소
dic['주소'].append(data_list[data_list.index('주소')+1])

# 영업시간
dic['영업시간'].append(data_list[data_list.index('영업시간')+1])

# 시설정보
dic['시설정보'].append(data_list[data_list.index('편의')+1])

# 업체소개
dic['업체소개'].append(
    data_list[data_list.index('설명')+1: data_list.index('접기')])(strip=True)

print(dic)

driver.quit()


# title = driver.find_element_by_class_name('_3XamX')  # 업체명
# phone_num = driver.find_element_by_class_name("_3ZA0S") # 전화번호
# address = driver.find_element_by_class_name("_2yqUQ") # 주소
# hours = driver.find_element_by_class_name("_2ZP3j") # 영업시간
# info = driver.find_element_by_css_selector("#app-root > div > div > div.place_detail_wrapper > div:nth-child(5) > div > div:nth-child(2) > div > ul > li:nth-child(5) > div") # 시설정보
# introduction = driver.find_element_by_class_name("WoYOw") # 업체소개
#temp.append([title.text, phone_num.text, address.text, hours.text, info.text, introduction.text])
# print(temp)


# 더이상 누를게 없을때 브레이크
# 다시 페이징으로 진입
