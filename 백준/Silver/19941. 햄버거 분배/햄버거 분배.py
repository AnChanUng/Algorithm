n, k = map(int, input().split())
word = list(input())

cnt = 0
for i in range(n):
    if word[i] == 'P':
        for j in range(max(i-k, 0), min(i+k+1, n)):
            if word[j] == 'H':
                word[j] = 0
                cnt += 1
                break

print(cnt)