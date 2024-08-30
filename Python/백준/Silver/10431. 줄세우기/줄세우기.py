p = int(input())
for _ in range(p):
    numbers = list(map(int, input().split())) 
    cnt = 0
    for i in range(1, len(numbers)-1):
        for j in range(i+1, len(numbers)):
            if numbers[i] > numbers[j]:
                numbers[i], numbers[j] = numbers[j], numbers[i]
                cnt += 1

    print(numbers[0], cnt)