from itertools import permutations

def solution(k, dungeons):
    max_cnt = 0
    original_k = k
    
    for i in permutations(dungeons, len(dungeons)):
        k = original_k
        cnt = 0
        #print("i", i)
        for a in i:
            if k >= a[0] and k >= a[1]:
                k -= a[1]
                cnt += 1
                #print("k", k)
                #print("cnt", cnt)
            max_cnt = max(max_cnt, cnt) 
    
    return max_cnt