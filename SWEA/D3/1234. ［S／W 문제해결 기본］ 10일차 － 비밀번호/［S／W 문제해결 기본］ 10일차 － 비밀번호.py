for test_case in range(1, 11):
    n, word = input().split()
    x = list(word)
    stack = []
    for num in x:
        if not stack:
            stack.append(num)
        else:
            if stack[-1] == num:
                stack.pop()
            else:
                stack.append(num)

    print(f'#{test_case}', ''.join(stack))