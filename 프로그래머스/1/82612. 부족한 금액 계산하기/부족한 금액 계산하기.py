def solution(price, money, count):
    
    result = 0
    all_price = 0
    
    for i in range(1, count+1):
        all_price += price * i
     
    if all_price >= money: 
        result = all_price - money
    else:
        return 0
    
    return result