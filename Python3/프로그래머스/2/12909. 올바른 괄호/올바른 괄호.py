def solution(s):
    answer = True
    
    stack = []
    for i in s:
        if not stack:
            if i == '(':
                stack.append('(')
            elif i == ')':
                return False
        else:
            if i == '(':
                stack.append('(')
            elif i == ')':
                stack.pop()
    
    if len(stack) == 0:
        return answer
    else:
        return False