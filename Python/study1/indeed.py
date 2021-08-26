import requests
from bs4 import BeautifulSoup
LIMIT = 50
URL = f"https://www.indeed.com/jobs?q=python&limit={LIMIT}"


def extract_indeed_pages():
    # 가져올 페이지 입력
    result = requests.get(URL)

    # 페이지에 쓸 soup 생성
    soup = BeautifulSoup(result.text, "html.parser")

    # soup 찾은걸 담는용도
    pagination = soup.find("div", {"class": "pagination"})

    # 찾은거에서 모든 a(링크)를 찾는다.
    # 찾은 링크를 리스트로 만들어준다.
    links = pagination.find_all('a')
    pages = []  # 빈 배열을 만들어주기
    for link in links[:-1]:  # 어디서부터 어디까지 가져올지 페이지 지정가능
        pages.append(int(link.string))  # span을 찾은다음 그 안에 있는 string만 가져온다.

    # 마지막 숫자만 가져오기
    max_page = pages[-1]
    return max_page


def extract_indeed_jobs(last_page):
    jobs = []
    # for page in range(last_page):
    result = requests.get(f"{URL}&start={0*LIMIT}")
    soup = BeautifulSoup(result.text, 'html.parser')

    results = soup.find_all("a", {"class": "fs-unmask"})  # 모든 일자리 찾기

    for result in results:
        jobTitle = result.find("h2", {"class": "jobTitle"})
        title = jobTitle.find("span", title=True).string

    if title == "new":
        title = jobTitle.find_all("span")[1].string
# print(title)

    company = result.find("span", {"class": "companyName"})
    has_company_anchor = company.find("a")
    if has_company_anchor is not None:
        company = str(has_company_anchor.string)
    else:
        company = str(company.string)
        company = company.strip()
        print(title, company)

    # print(company) #회사 목록 출력
    return jobs
