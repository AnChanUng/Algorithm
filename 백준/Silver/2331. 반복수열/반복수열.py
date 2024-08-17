a, p = map(int, input().split())

numbers = [a]
while True:
    tmp = 0
    for s in str(numbers[-1]):
        tmp += int(s) ** p
    
    if tmp in numbers:
        break

    else:
        numbers.append(tmp)

print(numbers.index(tmp))