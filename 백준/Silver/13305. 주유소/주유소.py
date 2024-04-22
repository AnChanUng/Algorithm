n = int(input())
length = list(map(int, input().split()))
liter = list(map(int, input().split()))

# 처음꺼는 무조건 사야함
# liter에 나보다 더 리터값이 작은게 있다면 적당히 구매
# 제일 싸면 다 구매

result = 0
for i in range(n-1):
    result = result + length[i] * liter[i]

print(result)