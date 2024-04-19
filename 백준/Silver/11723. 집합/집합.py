import sys
input = sys.stdin.readline
m = int(input())
s = set()
for _ in range(m):
    abc = input().split()

    if len(abc) == 1:
        if abc[0] == "all":
            s = set(range(1, 21))
        else:
            s = set()
    else:
        cd, x = abc[0], int(abc[1])
        if abc[0] == "add":
            s.add(x)

        elif abc[0] == "remove":
            s.discard(x)

        elif abc[0] == "check":
            if x in s:
                print(1)
            else:
                print(0)

        elif abc[0] == "toggle":
            if x in s:
                s.discard(x)
            else:
                s.add(x)