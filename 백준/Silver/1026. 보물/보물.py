n = int(input())
a_numbers = list(map(int, input().split()))
b_numbers = list(map(int, input().split()))

a_numbers.sort()
b_numbers.sort(reverse=True)

total = 0
for i in range(n):
    total += a_numbers[i] * b_numbers[i]

print(total)