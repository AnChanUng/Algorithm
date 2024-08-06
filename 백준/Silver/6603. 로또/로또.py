from itertools import combinations

while True:
    array = list(map(int, input().split()))

    k = array[0]
    s = array[1:]

    for i in combinations(s, 6):
        print(*i)
    
    if k == 0:
        exit()
    print()