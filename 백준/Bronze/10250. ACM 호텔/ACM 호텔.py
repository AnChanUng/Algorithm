t = int(input())
count = 0

for _ in range(t):
    #   호텔 층수, 각 층의 방 수, 몇번째 손님인지
    h, w, n = map(int, input().split())

    floor = (n-1) % h + 1 
    room = (n-1) // h + 1

    print(floor * 100 + room)