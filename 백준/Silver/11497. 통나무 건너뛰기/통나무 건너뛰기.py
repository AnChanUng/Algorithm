t = int(input())
for test_case in range(1, t+1):
    n = int(input())
    tree = list(map(int, input().split()))
    
    tree.sort()

    max_level = 0
    for i in range(2, n):
        max_level = max(max_level, abs(tree[i] - tree[i-2]))
    print(max_level)