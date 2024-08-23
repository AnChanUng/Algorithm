s = input()
n = len(s)
cnt = 0
array = set()
for length in range(1, n + 1):
    for start in range(n - length + 1):
        end = start + length
        array.add(s[start:end])

print(len(array))