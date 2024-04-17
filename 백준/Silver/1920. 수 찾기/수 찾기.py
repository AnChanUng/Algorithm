import sys
input = sys.stdin.readline

n = int(input())
number = set(map(int, input().split()))
m = int(input())
numbers = list(map(int, input().split()))

for i in numbers:
    if i in number:
        print(1)
    else:
        print(0)