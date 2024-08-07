n = int(input())
array = [0] * 10
for i in str(n):
    if i == "6" or i == "9":
        if array[6] == array[9]:
            array[6] += 1
        else:
            array[9] += 1
    
    else:
        array[int(i)] += 1

print(max(array))