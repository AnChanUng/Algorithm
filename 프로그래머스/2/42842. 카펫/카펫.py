def solution(brown, yellow):
    
    for height in range(1, int((yellow+brown)**0.5)+1):
        if (brown+yellow) % height == 0:
            width = (brown + yellow) // height
            if (width-2) * (height-2) == yellow:
                return [width, height]