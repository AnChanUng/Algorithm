array = sorted(map(int, input().split()))
result = array[0] + array[1] + min(array[2], array[0] + array[1]-1)
print(result)

