array = [list(input()) for _ in range(5)]

max_length = max(len(word) for word in array)

for i in range(max_length):
    for j in range(5):
        if i < len(array[j]):
            print(array[j][i], end="")