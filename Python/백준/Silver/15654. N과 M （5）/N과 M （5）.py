n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()

answer = []
def dfs():
    if len(answer) == m:
        print(" ".join(map(str, answer)))
        return
    
    for i in range(n):
        if numbers[i] not in answer:
            answer.append(numbers[i])
            dfs()
            answer.pop()

dfs()