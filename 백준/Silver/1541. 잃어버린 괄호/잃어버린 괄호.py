exp = input().split('-')

num = []
for i in exp:
    sum = 0
    tmp = i.split('+')
    for j in tmp:
        sum += int(j)
    num.append(sum)

n = num[0]  # 식의 제일 처음은 숫자로 시작하기 때문에 0번째 값에서 나머지 값들을 빼준다.

for i in range(1, len(num)):
    n = n - num[i]

print(n)