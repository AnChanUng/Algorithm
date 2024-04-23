n = int(input())
count = 0
for a in range(1, 100):
    for b in range(1, 100):
        for c in range(1, 100):
            if a + b + c == n:
                if a >= b + 2:
                    if c % 2 == 0:
                        count += 1

print(count)