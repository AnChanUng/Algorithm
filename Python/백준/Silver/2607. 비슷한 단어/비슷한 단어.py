n = int(input())
target = list(input())

res = 0
for _ in range(n-1):
    copy_target = target[:]
    word = input()
    cnt = 0
    for i in word:
        if i in copy_target:
            copy_target.remove(i)
        else:
            cnt += 1

    if cnt < 2 and len(copy_target) < 2:
        res += 1

print(res)