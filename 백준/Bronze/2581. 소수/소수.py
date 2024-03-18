start_num = int(input())
last_num = int(input())

sosu = []

for num in range(start_num, last_num+1):
    error = 0
    if num > 1:
        for i in range(2, num):
            if num % i == 0:
                error += 1
                break
        if error == 0:
            sosu.append(num)

if len(sosu) > 0:
    print(sum(sosu))
    print(min(sosu))
else:
    print(-1)