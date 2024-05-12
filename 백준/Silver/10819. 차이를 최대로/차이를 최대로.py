from itertools import permutations
import sys
input = sys.stdin.readline

n = int(input().rstrip())
array = list(map(int, input().split()))
max_result = 0
for numbers in permutations(array, n):
    result = 0
    for i in range(n-1):
        result += abs(numbers[i] - numbers[i+1])
        max_result = max(result, max_result)

print(max_result)