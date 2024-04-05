n = int(input())

array = []
for i in range(n):
    array.append(int(input()))

array.sort(reverse=True)

result = 0
for i in range(2, len(array), 3):
    result += array[i]

print(sum(array)-result)