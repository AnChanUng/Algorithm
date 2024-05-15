s = list(input())

count_0 = s.count('0') // 2
count_1 = s.count('1') // 2

for _ in range(count_0):
    s = s[::-1]
    s.remove('0')
    s = s[::-1]

for _ in range(count_1):
    s.remove('1')

print(''.join(s))