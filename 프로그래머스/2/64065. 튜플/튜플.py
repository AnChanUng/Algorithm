def solution(s):
    
    s = s[2:-2].split("},{")
    arr = []
    for i in range(len(s)):
        s1 = s[i].split(",")
        arr.append(set(s1))
    
    arr.sort(key=lambda x: len(x))
    
    ans = set()
    res = []
    for a in arr:
        tmp = a - ans
        res.append(list(tmp)[0])
        ans = ans | tmp
    
    res = [int(i) for i in res]
    return res
    