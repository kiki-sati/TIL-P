import csv

def save_to_file(jobs):
  file = open("jobs.csv", mode="w")
  writer = csv.writer(file)
  writer.writerow(["title","company","location","link"])
  for job in jobs:
    writer.writerow(list(job.values()))#딕셔너리 : 오직 값만 가져올 수 있다.
  return