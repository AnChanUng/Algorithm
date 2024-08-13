s = input()

number = 0
array = []
for i in s:
    if i.isdigit():
        number += int(i)
    else:
        array.append(i)

array.sort()

if number != 0:
    array.append(str(number))

print(''.join(array))