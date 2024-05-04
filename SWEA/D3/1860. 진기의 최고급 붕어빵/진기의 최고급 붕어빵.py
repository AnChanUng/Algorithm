t = int(input())
for test_case in range(1, t+1):
    n, m, k = map(int, input().split())
    arrive_time = list(map(int, input().split()))
    arrive_time.sort()

    result = "Possible"
    # n초까지 만들어진 붕어 개수 : (x//m) * k
    for i in range(n):
        bread = (arrive_time[i] // m) * k - (i+1)
        if bread < 0:
            result = "Impossible"
            break
    
    print(f'#{test_case}', result)