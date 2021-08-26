from indeed import get_jobs as get_indeed_jobs
from so import get_jobs as get_so_jods
from save import save_to_file


so_jobs = get_so_jods()
indeed_jobs = get_indeed_jobs()
jobs = indeed_jobs + so_jobs
save_to_file(jobs)
