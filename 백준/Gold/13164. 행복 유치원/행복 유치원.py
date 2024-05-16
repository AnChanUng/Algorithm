n, k = map(int, input().split())
height = list(map(int, input().split()))

height.sort()

array = []
for i in range(n-1):
    array.append(height[i+1] - height[i])
  
array.sort()

print(sum(array[0:n-k]))