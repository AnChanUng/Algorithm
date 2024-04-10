total = []
for i in range(1, 31):
    total.append(i)

for _ in range(28):
    n = int(input())
    total.remove(n)

for i in total:
    print(i)