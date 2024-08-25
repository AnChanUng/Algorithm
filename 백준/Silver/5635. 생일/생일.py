n = int(input())
# 이름 생일 
array = []
for _ in range(n):
    inf = input().split()
    name = inf[0]
    year = int(inf[3])
    month = int(inf[2])
    day = int(inf[1])
    array.append([name, day, month, year])

array.sort(key=lambda x: (x[3], x[2], x[1]), reverse=True)

print(array[0][0])

array.sort(key=lambda x: (x[3], x[2], x[1]))
print(array[0][0])