import requests
from bs4 import BeautifulSoup

URL = f"https://stackoverflow.com/jobs?q=python&pg=i"


#마지막 페이지 구하는 함수
def get_last_page():
    result = requests.get(URL)
    soup = BeautifulSoup(result.text, "html.parser")
    pages = soup.find("div", {"class": "s-pagination"}).find_all("a")
    #next 없애주기
    last_page = pages[-2].get_text(strip=True)  #공백제거
    return int(last_page)


#soup 오브젝트. html 가져오기/ 일자리 추출
def extract_job(html):
    title = html.find("h2", {"class": "mb4"}).find("a")["title"]
    #두개의 조건이 있을 때
    company, location = html.find("h3").find_all("span", recursive=False)  #전부 가져오는걸 방지
    company = company.get_text(strip=True)
    location = location.get_text(strip=True)
    job_id = html['data-jobid']
    return {
        'title': title,
        'company': company,
        'location': location,
        "apply_link": f"https://stackoverflow.com/jobs/{job_id}"
    }


#모든 job 가져오기
def extract_jobs(last_page):
    jobs = []
    for page in range(last_page):
        print(f"Scrapping SO: page:{page}")
        result = requests.get(f"{URL}&pg={page+1}")
        soup = BeautifulSoup(result.text, "html.parser")
        results = soup.find_all("div", {"class": "-job"})
        for result in results:
            job = extract_job(result)
            print(job)
            jobs.append(job)
    return jobs


def get_jobs():
    last_page = get_last_page()
    jobs = extract_jobs(last_page)
    return jobs
