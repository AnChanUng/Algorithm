def solution(price, money, count):
    
    result = 0
    for i in range(price, price*count+1, price):
        result = result + i
    
    if result - money <= 0:
        return 0
    else:
        return result - money