array = []
for _ in range(9):
    key = int(input())
    array.append(key)

# 전체 키를 더하고 두명을 빼서 100이 되는걸 구해라.

for i in array:
    for j in array:
        if i != j:
            if sum(array) - (i+j) == 100:
                array.remove(i)
                array.remove(j)

array.sort()

for i in array:
    print(i)