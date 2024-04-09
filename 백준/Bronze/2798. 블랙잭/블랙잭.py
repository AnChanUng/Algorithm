n, m = map(int, input().split())
card_number = list(map(int, input().split()))

result = 0
for i in range(n-2):
    for j in range(i+1, n-1):
        for k in range(j+1, n):
            temp_sum = card_number[i] + card_number[j] + card_number[k]
            if temp_sum <= m and temp_sum > result:
                result = temp_sum
print(result)