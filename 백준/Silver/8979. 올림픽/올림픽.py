n, k = map(int, input().split())

array = []
for _ in range(n):
    rank = list(map(int, input().split()))
    country_id, gold, silver, bronze = rank
    array.append((country_id, gold, silver, bronze))

array.sort(key=lambda x: (x[1], x[2], x[3]), reverse=True)

# 국가의 등수를 매기기 위한 함수
rank = 1
prev_medals = None
rank_dict = {}
for i in range(n):
    country_id, gold, silver, bronze = array[i]

    current_medals = (gold, silver, bronze)
    
    if current_medals != prev_medals:
        rank = i + 1
    
    rank_dict[country_id] = rank
    prev_medals = current_medals

print(rank_dict[k])