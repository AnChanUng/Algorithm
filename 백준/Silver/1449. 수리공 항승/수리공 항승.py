n, l = map(int, input().split())
where = list(map(int, input().split()))

where.sort(reverse=True)

max_where = where[0]
cnt = 1
for i in where:
    if max_where-l+0.5 <= i and i <= max_where+0.5:
        continue
    else:
        max_where = i
        cnt += 1
print(cnt)