while True:
    s = int(input())

    if s == 0:
        break

    if str(s) == str(s)[::-1]:
        print("yes")
    else:
        print("no")
