N = int(input())
arr = []

for _ in range(N):
    a = input()
    arr.append(a)

set_arr = set(arr)
arr = list(set_arr)

arr.sort()
arr.sort(key=len)  # 문자열 길이 순으로 정렬

for i in arr:
    print(i)