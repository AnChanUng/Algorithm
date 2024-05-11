money = int(input())
total_money = 1000-money

cnt = 0
while True:
    if 500 <= total_money:
        cnt += total_money // 500 
        total_money = total_money % 500
    elif 100 <= total_money:
        cnt += total_money // 100
        total_money = total_money % 100
    elif 50 <= total_money:
        cnt += total_money // 50
        total_money = total_money % 50
    elif 10 <= total_money:
        cnt += total_money // 10
        total_money = total_money % 10
    elif 5 <= total_money:
        cnt += total_money // 5
        total_money = total_money % 5
    else:
        total_money = total_money - 1
        cnt += 1
    
    if total_money <= 0:
        break

print(cnt)