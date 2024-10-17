h, w = map(int, input().split())
block = list(map(int, input().split()))

answer = 0
for i in range(1, len(block)-1):
    left = max(block[:i])
    right = max(block[i+1:])
    
    min_block = min(left, right)
    if min_block > block[i]:
        answer += min_block - block[i]

print(answer)