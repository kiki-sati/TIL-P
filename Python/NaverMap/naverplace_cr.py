from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
from bs4 import BeautifulSoup
import pandas as pd
import re

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
search.send_keys("염창 필라테스")
search.send_keys(Keys.RETURN)


# 시간 지연
time.sleep(2)

# 처음 화면
html = browser.page_source
soup = BeautifulSoup(html, "lxml")


# 업체리스트 Iframe 진입
search_iframe = browser.switch_to.frame("searchIframe")

browser.find_element_by_class_name("_3Apve").click()
# print("타이틀 클릭 완료")

# 시간 지연
time.sleep(3)

#  장소 상세 Ifram 진입
browser.switch_to.default_content()  # 처음 상태로 돌아오기
browser.switch_to.frame("entryIframe")
# print("장소 상세 진입")

# 더보기를 누르기
try:
    btn_more1 = browser.find_element_by_class_name('_3erXy')
    btn_more1.click()
    time.sleep(1)
except:
    pass

try:
    btn_more = browser.find_element_by_class_name('_3Dnsh')
    btn_more.click()
    time.sleep(1)
except:
    pass

# 원하는 데이터 수집


# 원하는 데이터 수집

dic = {}
for i in ['업체명', '전화번호', '주소', '영업시간', '시설정보', '업체소개']:
    dic[i] = []

data = browser.find_element_by_class_name('place_detail_wrapper')
data = data.text
data_list = data.split('\n')
print(data)

# 업체명
dic['업체명'].append(data_list[0])

# 전화번호
pn = re.findall(r'\d{2,4}-\d{3,4}-\d{4}', data)
dic['전화번호'].append(pn[0])

# 주소
dic['주소'].append(data_list[data_list.index('주소')+1])

# 영업시간
open_hour = dic['영업시간'].append(
    data_list[data_list.index('영업시간')+1: data_list.index('접기')])
open_str = ''
info = data_list[data_list.index('영업시간')+1: data_list.index('접기')]
info_str = ''
for i in info:
    info_str += i
dic['영업시간'].remove('펼쳐보기')
dic['영업시간'].append(info_str)


print(dic)

# 시설정보
dic['시설정보'].append(data_list[data_list.index('편의')+1])


# 업체소개(합쳐줘야 함)
try:
    info = data_list[data_list.index('설명')+1: data_list.index('접기')]
    info_str = ''
    for i in info:
        for j in i:
            info_str += j
    dic['업체소개'].append(info_str)
except:
    dic['업체소개'].append('')


# title = browser.find_element_by_class_name('_3XamX')  # 업체명
# phone_num = browser.find_element_by_class_name("_3ZA0S") # 전화번호
# address = browser.find_element_by_class_name("_2yqUQ") # 주소
# hours = browser.find_element_by_class_name("_2ZP3j") # 영업시간
# info = browser.find_element_by_css_selector("#app-root > div > div > div.place_detail_wrapper > div:nth-child(5) > div > div:nth-child(2) > div > ul > li:nth-child(5) > div") # 시설정보
# introduction = browser.find_element_by_class_name("WoYOw") # 업체소개
# temp.append([title.text, phone_num.text, address.text, hours.text, info.text, introduction.text])
# print(temp)


# 더이상 누를게 없을때 브레이크
# 다시 페이징으로 진입
