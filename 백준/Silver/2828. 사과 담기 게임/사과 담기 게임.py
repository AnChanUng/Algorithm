n, m = map(int, input().split())
j = int(input())

array = []
for _ in range(j):
    apple = int(input())   
    array.append(apple)

now = 1
answer = 0
for apple in array:
    if now <= apple and now + (m-1) >= apple:
        pass
    elif now > apple:
        answer += abs(apple-now)
        now = apple
    else:
        answer += apple - (m-1) - now
        now = apple - (m-1)

print(answer)