n = int(input())
time = list(map(int, input().split()))
time.sort()

array = []
result = 0
for i in time:
    result += i
    array.append(result)

print(sum(array))