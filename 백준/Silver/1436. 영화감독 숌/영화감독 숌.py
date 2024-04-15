n = int(input())

# 0666 1666 2666 3666 4666
# 6이 세번이상 들어가야함

count = 0
num = 666

while True:
    if '666' in str(num):
        count += 1

    if count == n:
        break

    num += 1

print(num)