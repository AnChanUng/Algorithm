number = int(input())
target = list(input())
answer = 0

for i in range(number-1):
    word = input()
    cnt = 0
    compare = target[:]  
    
    for i in word:
        if i in compare:
            compare.remove(i)
        else:
            cnt += 1
    if cnt < 2 and len(compare) < 2:
        answer += 1

print(answer)