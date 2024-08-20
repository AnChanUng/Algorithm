n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()
answer = []

def backtracking(start):
    if len(answer) == m:
        print(*answer)
        return
    
    remember = 0
    for i in range(start, n):
        if remember != numbers[i]:
            answer.append(numbers[i])
            remember = numbers[i]
            backtracking(i)
            answer.pop()

backtracking(0)