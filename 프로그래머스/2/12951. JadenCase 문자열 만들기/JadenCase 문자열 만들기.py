def solution(s):
    
    s = s.split(" ")
    array = []
    for i in range(len(s)):
        array1 = []
        for j in range(len(s[i])):
            if j == 0:
                array1.append(s[i][j].upper())
            else:
                array1.append(s[i][j].lower())
        array.append(''.join(array1))
    
    return ' '.join(array)