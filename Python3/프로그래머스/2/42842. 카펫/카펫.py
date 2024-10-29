def solution(brown, yellow):
    answer = []
    
    for garo in range(1, brown+yellow+1):
        if (brown+yellow) % garo == 0:
            # yellow = (garo-2) * (sero-2)
            # brown = (garo*2) + (sero-2)*2
            # yellow + brown = garo * sero
            sero = (brown+yellow) // garo
            
            if (garo-2) * (sero-2) == yellow:
                return [sero, garo]