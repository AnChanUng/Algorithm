house = int(input())
antena = list(map(int, input().split()))

antena.sort()

print(antena[(house-1) // 2])