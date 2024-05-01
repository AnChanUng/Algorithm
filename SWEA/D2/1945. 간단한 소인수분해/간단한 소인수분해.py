t = int(input())
for i in range(1, t+1):
    n = int(input())

    count = [0, 0, 0, 0, 0]
    while n > 1:
        if n % 11 == 0:
            count[4] += 1
            n = n // 11
        elif n % 7 == 0:
            count[3] += 1
            n = n // 7
        elif n % 5 == 0:
            count[2] += 1
            n = n // 5
        elif n % 3 == 0:
            count[1] += 1
            n = n // 3
        elif n % 2 == 0:
            count[0] += 1
            n = n // 2

    print(f"#{i}", *count)
