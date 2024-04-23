n, kimjimin, imhansu = map(int, input().split())
cnt = 0

while kimjimin != imhansu:
    kimjimin -= kimjimin // 2
    imhansu -= imhansu // 2
    cnt += 1
print(cnt)