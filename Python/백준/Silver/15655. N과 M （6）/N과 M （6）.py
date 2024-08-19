n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

answer = []
def dfs(start):
    if len(answer) == m:
        print(" ".join(map(str, answer)))
        return
    
    for i in range(start, n):
        if numbers[i] not in answer:
            answer.append(numbers[i])
            dfs(i)
            answer.pop()

dfs(0)