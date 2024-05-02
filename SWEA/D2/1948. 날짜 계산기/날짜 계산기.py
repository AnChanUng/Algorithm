t = int(input())
for i in range(1, t+1):
    m1, d1, m2, d2 = map(int, input().split())
    month = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365]

    result = (month[m2-1] + d2) - (month[m1-1] + d1) + 1

    print(f'#{i}', result)
