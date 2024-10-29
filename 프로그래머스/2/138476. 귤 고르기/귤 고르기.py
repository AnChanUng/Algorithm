def solution(k, tangerine):
        
    dic = {}
    for i in range(len(tangerine)):
        if tangerine[i] in dic:
            dic[tangerine[i]] += 1
        else:
            dic[tangerine[i]] = 1
    
    sorted_dic = sorted(dic.items(), key=lambda item: item[1], reverse=True)
    
    cnt = 0
    for a, b in sorted_dic:
        k = k - b
        cnt += 1
        if k <= 0:
            break
    
    return cnt