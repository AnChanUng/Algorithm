n = int(input())
array = [[0 for _ in range(101)] for _ in range(101)]

for _ in range(n):
    x, y = list(map(int, input().split()))

    for row in range(x, x+10):
        for col in range(y, y+10):
            array[row][col] = 1

result = 0

for i in array:
    result += i.count(1)
print(result)
