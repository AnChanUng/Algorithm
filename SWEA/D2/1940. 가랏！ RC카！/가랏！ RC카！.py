T = int(input())

for i in range(1, T+1):

    N = int(input())  # command의 수
    speed = 0
    distance = 0

    for _ in range(N):
        command = list(map(int, input().split()))
        if command[0] == 1:
            speed += command[1]
        elif command[0] == 2:
            if speed > command[1]:
                speed -= command[1]
            else:
                speed = 0
        distance += speed

    print(f'#{i} {distance}')