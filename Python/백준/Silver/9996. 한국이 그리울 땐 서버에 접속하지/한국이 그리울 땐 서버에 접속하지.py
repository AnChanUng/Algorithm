n = int(input())
pattern = input().split("*")
prefix = pattern[0]
suffix = pattern[1]

for _ in range(n):
    word = input()
    
    if len(word) >= len(prefix) + len(suffix) and word.startswith(prefix) and word.endswith(suffix):
        print("DA")
    else:
        print("NE")