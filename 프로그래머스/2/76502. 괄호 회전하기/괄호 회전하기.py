def is_valid(s):
    
    stack = []
    for i in s:
        if i in '[{(':
            stack.append(i)
        elif i == ']':
            if not stack or stack[-1] != '[':
                return False
            stack.pop()
        elif i == '}':
            if not stack or stack[-1] != '{':
                return False
            stack.pop()
        elif i == ')':
            if not stack or stack[-1] != '(':
                return False
            stack.pop()
            
    return len(stack) == 0

def solution(s):
    cnt = 0
    for _ in range(len(s)):
        if is_valid(s):
            cnt += 1
        s = s[1:] + s[0]
    
    return cnt