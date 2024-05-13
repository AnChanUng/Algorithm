import sys
input = sys.stdin.readline

t = int(input())
for _ in range(t):
    n = int(input())
    numbers = list(map(int, input().split()))

    max_price = 0
    max_profit = 0

    for price in numbers[::-1]:
        if price > max_price:
            max_price = price
        else:
            max_profit += max_price - price
    
    print(max_profit)