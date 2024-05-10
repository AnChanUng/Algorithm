t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    prices = list(map(int, input().split()))

    max_price = 0
    max_profit = 0

    for price in prices[::-1]:
        if price > max_price:
            max_price = price
        else:
            max_profit += max_price - price
    
    print(f'#{test_case}', max_profit)