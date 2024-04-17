while True:
    array = list(map(int, input().split()))

    if array.count(0) == 3:
        break

    array.sort()
    if array[0] ** 2 + array[1] ** 2 == array[2] ** 2:
        print("right")
    else:
        print("wrong")