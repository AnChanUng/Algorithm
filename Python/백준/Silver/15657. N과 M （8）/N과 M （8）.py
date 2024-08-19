import sys
input = sys.stdin.readline

n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

answer = []
def dfs(start):
    if len(answer) == m:
        print(" ".join(map(str, answer)))
        return
    
    for i in range(start, n):
        answer.append(numbers[i])
        dfs(i)
        answer.pop()

dfs(0)