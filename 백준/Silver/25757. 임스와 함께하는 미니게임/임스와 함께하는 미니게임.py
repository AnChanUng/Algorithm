import sys
input = sys.stdin.readline

n, type_char = input().split()
if type_char == 'Y':
    type = 2
elif type_char == 'F':
    type = 3
elif type_char == 'O':
    type = 4

n = int(n)
words = [input().strip() for _ in range(n)]

unique_words = []
word_count = {}

for word in words:
    if word not in word_count:
        word_count[word] = 0
    word_count[word] += 1

res = 0
cnt = 0

for word in word_count:
    cnt += 1
    if cnt == type - 1:
        res += 1
        cnt = 0

print(res)