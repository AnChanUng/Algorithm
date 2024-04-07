n = int(input())
energyDrink = list(map(int, input().split()))

# 더 커지려면 큰거에 작은걸 부워야함
energyDrink.sort(reverse=True)
# [10 9 6 3 2]
# 가장 큰거를 기준으로 작은것들 계속 넣기
bigDrink = energyDrink[0]
for i in range(1, len(energyDrink)):
    if bigDrink > energyDrink[i]:
        bigDrink = bigDrink + (energyDrink[i] / 2)
        
print(bigDrink)