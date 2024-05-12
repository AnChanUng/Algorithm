import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    n = int(input())
    array = []
    for i in range(n):
        grade_1, grade_2 = map(int, input().split())
        array.append((grade_1, grade_2))

    array.sort(key=lambda x:x[0])
    cnt = 1
    check = array[0][1]
    for i in range(1, n):
        if array[i][1] < check:
            check = array[i][1]
            cnt += 1
    print(cnt)