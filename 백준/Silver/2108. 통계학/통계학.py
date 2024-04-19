from collections import Counter
import sys
input = sys.stdin.readline

n = int(input())
array = []
for _ in range(n):
    num = int(input())
    array.append(num)

for i in range(4):
    if i == 0:
        print(round(sum(array)/n))
    elif i == 1:
        array.sort()
        print(array[n//2])
    elif i == 2:
        cnt = Counter(array).most_common(2)

        if len(array) > 1:
            if cnt[0][1] == cnt[1][1]:
                print(cnt[1][0])
            else:
                print(cnt[0][0])
        else:
            print(cnt[0][0])
    elif i == 3:
        print(max(array) - min(array))
    elif i == 4:
        print(max(array) - min(array))