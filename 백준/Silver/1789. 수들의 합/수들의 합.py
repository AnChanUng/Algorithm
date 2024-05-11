s = int(input())
result = 0
n = 0
while True:
    n += 1
    result += n

    if result > s:
        print(n-1)
        break