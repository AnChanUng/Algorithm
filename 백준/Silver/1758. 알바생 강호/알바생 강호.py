n = int(input())

array = []
for i in range(n):
    array.append(int(input()))

array.sort(reverse=True)
tips = []
for i in range(1, n+1):
    tip = array[i-1] - (i - 1)

    if tip > 0:
        tips.append(tip)

print(sum(tips))