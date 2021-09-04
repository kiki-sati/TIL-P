line_counter = 0   # csv 파일의 총 행의 수
data_header = []  # 리스트의 해더
sample_list = []  # 리스트의 요소(행)

# csv -> sample_list 리스트에 저장
with open('healthtest.csv') as file:
    while True:
        data = file.readline()

        # 마지막 줄 -> 더이상 가져올 데이터가 없으면 None 반환 -> 반복문 탈출
        if not data:
            break

        if line_counter == 0:  # header 저장
            data_header = data.split(',')
        else:
            sample_list.append(data.split(','))
            line_counter += 1

        

print('total-Count', line_counter)
