from itertools import combinations

n = int(input())
score = [list(map(int, input().split())) for _ in range(n)]

diff = 1000000
for comb in combinations(range(n), n//2):
    a_team = list(comb)
    b_team = [i for i in range(0, n) if i not in a_team]

    a_score = 0
    b_score = 0

    for i in range(0, len(a_team)-1):
        for j in range(i+1, len(a_team)):
            a_score += score[a_team[i]][a_team[j]] + score[a_team[j]][a_team[i]]
            b_score += score[b_team[i]][b_team[j]] + score[b_team[j]][b_team[i]]
            
    diff = min(diff, abs(a_score - b_score))

print(diff)