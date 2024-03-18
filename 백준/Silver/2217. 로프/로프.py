rope_num = int(input())
rope_array = []

for i in range(rope_num):
    rope_array.append(int(input()))
rope_array.sort(reverse=True)

for i in range(rope_num):
    rope_array[i] = rope_array[i] * (i+1)

print(max(rope_array))