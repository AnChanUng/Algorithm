n, m = map(int, input().split())

not_mix = set()

for _ in range(m):
    a, b = map(int, input().split())
    not_mix.add((a, b))
    not_mix.add((b, a))

count = 0
for i in range(1, n+1):
    for j in range(i+1, n+1):
        for k in range(j+1, n+1):
            if i != j or j != k or i != k:
                if (i, j) not in not_mix and (i, k) not in not_mix and (j, k) not in not_mix:
                    count += 1
print(count)