from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
from bs4 import BeautifulSoup
import pandas as pd
import re


def click_nolink_for_scrollDown(driver, scrollDown_num=30):
    url = driver.current_url
    while True:
        try:
            body = driver.find_element_by_css_selector('body')
        except:
            driver.refresh()
            time.sleep(0.5)
        body.click()
        time.sleep(0.1)
        if url == driver.current_url:
            break
        else:
            driver.execute_script("window.history.go(-1)")
    time.sleep(0.1)
    for i in range(scrollDown_num):
        time.sleep(0.1)
        body.send_keys(Keys.PAGE_DOWN)


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
# print("검색완료")

# 시간 지연
time.sleep(2)

# 처음 화면
html = browser.page_source
soup = BeautifulSoup(html, "lxml")

dic = {}
for i in ['placename', 'placeaddress', 'placephone', 'placeinfo', 'placeintro', 'openhour', 'placeimg']:
    dic[i] = []

# 페이지 개수에 따라 range 수정
for page in range(3, 4):
    # 업체리스트 Iframe 진입
    search_iframe = browser.switch_to.frame("searchIframe")
    click_nolink_for_scrollDown(browser, 30)
    titles = browser.find_elements_by_class_name("_3Apve")

    for t in titles:

        t.click()

        # 시간 지연
        time.sleep(3)

        #  장소 상세 Ifram 진입
        browser.switch_to.default_content()  # 처음 상태로 돌아오기
        browser.switch_to.frame("entryIframe")
        #print("장소 상세 진입")

        # 더보기를 누르기

        try:
            btn_more = browser.find_element_by_class_name('_3Dnsh')
            btn_more.click()
            time.sleep(1)
        except:
            pass

        try:
            place_introduce_open = browser.find_element_by_class_name('_3erXy')
            place_introduce_open.click()
            time.sleep(1)
        except:
            pass

        place_time_lists = browser.find_elements_by_css_selector(
            '.place_section_content ._2KHqk ._1h3B_ ._2BDci._2ZP3j ._3XVfx ._20pEw')

        # 원하는 데이터 수집

        data = browser.find_element_by_class_name('place_detail_wrapper')
        data = data.text
        data_list = data.split('\n')

        # 업체명
        dic['placename'].append(data_list[0])

        try:
            # 전화번호
            pn = re.findall(r'\d{2,4}-\d{3,4}-\d{4}', data)
            dic['placephone'].append(pn[0])
        except:
            dic['placephone'].append('')

        try:
            # 주소
            dic['placeaddress'].append(data_list[data_list.index('주소')+1])
        except:
            dic['placeaddress'].append('')

        try:
            # 영업시간
            dic['openhour'].append(data_list[data_list.index('openhour')+1])
        except:
            dic['openhour'].append('')

        try:
            # 시설정보
            dic['placeinfo'].append(data_list[data_list.index('편의')+1])
        except:
            dic['placeinfo'].append('')

        # 업체소개(합쳐줘야 함)
        try:
            info = data_list[data_list.index('설명')+1: data_list.index('접기')]
            info_str = ''
            for i in info:
                for j in i:
                    info_str += j
            dic['placeintro'].append(info_str)
        except:
            dic['placeintro'].append('')

        # 사진 추가
        htmlsrc = browser.page_source
        bs = BeautifulSoup(htmlsrc, 'html.parser')
        pic = bs.find_all('div', {"class": "cb7hz _div"})
        images = [str(i)[86:-44] for i in pic]
        image = ', '.join(images)
        dic['placeimg'].append(image)

        # 업체리스트 프레임으로 복귀
        browser.switch_to.default_content()
        search_iframe = browser.switch_to.frame("searchIframe")
        time.sleep(1)

    btn_page = browser.find_element_by_xpath(
        '//*[@id="app-root"]/div/div/div[2]/a[%d]' % page)
    btn_page.click()
    time.sleep(1)
    browser.switch_to.default_content()
    time.sleep(1)


result = pd.DataFrame(dic)
result.to_csv('result.csv')
