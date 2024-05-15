n = int(input())
cards = list(map(int, input().split()))
cards.sort(reverse=True)
level = cards[0]

gold = 0
for i in range(1, n):
    gold += level + cards[i]
    if level >= cards[i]:
        pass
    else:
        level = cards[i]

print(gold)