t = int(input())
for i in range(1, t+1):
    n = int(input())
    array = set()
    count = 0
    while len(array) < 10:
        count += 1
        for j in range(len(str(n*count))):
            array.add(str(n*count)[j])

    print(f'#{i}', count*n)