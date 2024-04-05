n = int(input())
time = list(map(int, input().split()))

time.sort()

result = 0
array = []
for i in time:
    result += i
    array.append(result)

print(sum(array))