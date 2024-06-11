def solution(N, stages):
    answer = []
    ratio = {}
    player = len(stages)
    for i in range(1, N+1):
        if player == 0:
            ratio[i] = 0
        else:
            ratio[i] = stages.count(i) / player
            player = player - stages.count(i)
    
    answer = sorted(ratio, key=lambda x : ratio[x], reverse=True)
    
    return answer