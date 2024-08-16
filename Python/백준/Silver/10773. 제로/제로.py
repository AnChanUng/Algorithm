# [백준 10773번] - 제로 - (실버4, 스택)
import sys
input = sys.stdin.readline

count = int(input())
stack = []

for i in range(count):
    k = int(input())
    if k == 0:
      stack.pop()
    else:
      stack.append(k)

print(sum(stack))