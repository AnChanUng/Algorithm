T = int(input())

for i in range(T):
    stack = []
    a = input()
    for j in a:
        if j == '(':
            stack.append(j)
        elif j == ')':
            if stack:
                stack.pop()
            else: # 스택에 괄호가 없을경우 NO
                print("NO")
                break
    else:
        if not stack:
            print("YES")
        else:
            print("NO")