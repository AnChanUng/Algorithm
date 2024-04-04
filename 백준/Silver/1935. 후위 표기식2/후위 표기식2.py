n = int(input())
expression = list(input())
num = [int(input()) for i in range(n)]
# 후위 표기식을 저장하는 배열과 알파벳 값을 저장할 배열을 선언해 준다.

stk = []

for i in expression:
    if i.isalpha():
        stk.append(num[ord(i)-65])
    else:
        a = stk.pop()
        result = stk.pop()

        if i == "+":
            result += a

        elif i == "-":
            result -= a

        elif i == "*":
            result *= a

        elif i == '/':
            result /= a

        stk.append(result)

print("%.2f" % stk[-1])