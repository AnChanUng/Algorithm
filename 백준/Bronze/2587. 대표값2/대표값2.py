array = []
for i in range(5):
    array.append(int(input()))
result = (sum(array)/5)
print(f"{result:g}")
print(sorted(array)[2])

