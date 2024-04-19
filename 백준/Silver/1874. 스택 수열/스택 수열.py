n = int(input())
stack = []
result = []
count = 0
flag = True

for _ in range(n):
    num = int(input())

    while count < num:
        count += 1
        stack.append(count)
        result.append("+")

    if stack[-1] == num:
        stack.pop()
        result.append("-")
    else:
        flag = False
        break

if flag == False:
    print("NO")
else:
    print('\n'.join(result))