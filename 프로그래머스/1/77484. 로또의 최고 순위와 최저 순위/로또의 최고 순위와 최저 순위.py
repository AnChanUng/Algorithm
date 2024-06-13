def solution(lottos, win_nums):
    answer = []
    
    cnt = 0
    for i in range(len(win_nums)):
        if lottos[i] in win_nums:
            cnt += 1
    
    max_rank = cnt + lottos.count(0)
    min_rank = cnt
    
    if max_rank == 6:
        answer.append(1)
    elif max_rank == 5:
        answer.append(2)
    elif max_rank == 4:
        answer.append(3)
    elif max_rank == 3:
        answer.append(4)
    elif max_rank == 2:
        answer.append(5)
    else:
        answer.append(6)
    
    if min_rank == 6:
        answer.append(1)
    elif min_rank == 5:
        answer.append(2)
    elif min_rank == 4:
        answer.append(3)
    elif min_rank == 3:
        answer.append(4)
    elif min_rank == 2:
        answer.append(5)
    else:
        answer.append(6)
    
    return answer