from itertools import permutations

def solution(k, dungeons):
    answer = 0
    for i in permutations(dungeons, len(dungeons)):
        count = 0
        tmp = k
        for need, spend in i:
            if tmp >= need:
                tmp -= spend
                count += 1
        answer = max(answer, count)
        
    return answer