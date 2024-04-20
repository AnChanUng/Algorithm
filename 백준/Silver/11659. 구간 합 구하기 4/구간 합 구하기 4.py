import sys
input = sys.stdin.readline

n, m = map(int, input().split())
n_list = list(map(int, input().split()))

cumlative_sum = [0] * (n+1)
for i in range(1, n+1):
    cumlative_sum[i] = cumlative_sum[i-1] + n_list[i-1]

for _ in range(m):
    i, j = map(int, input().split())

    print(cumlative_sum[j]-cumlative_sum[i-1])