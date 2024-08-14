import sys
input = sys.stdin.readline

n = int(input().strip())

array = []
for _ in range(n):
    words = input().strip().split()
    array.append(words)
        
array.sort(key=lambda x: int(x[0]))

for i in array:
    print(" ".join(i))