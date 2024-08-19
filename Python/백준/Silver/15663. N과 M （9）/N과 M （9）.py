n, m = map(int, input().split())
numbers = list(map(int, input().split()))
visited = [False] * n
numbers.sort()
result = []

def backtracking(k):
    if k == m:
        print(*result)
        return
    
    remember = 0
    for i in range(n):
        if not visited[i] and remember != numbers[i]:
            visited[i] = True
            result.append(numbers[i])
            remember = numbers[i]
            backtracking(k+1)
            visited[i] = False
            result.pop()

backtracking(0)