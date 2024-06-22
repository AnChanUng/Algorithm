from collections import Counter
def solution(str1, str2):
    
    str1 = str1.upper()
    str2 = str2.upper()
    
    pairs1 = [str1[i:i+2] for i in range(len(str1)-1)]
    pairs2 = [str2[i:i+2] for i in range(len(str2)-1)]
    
    answer1 = []
    for i in range(len(pairs1)):
        if pairs1[i].isalpha():
            answer1.append(pairs1[i])
    
    answer2 = []
    for i in range(len(pairs2)):
        if pairs2[i].isalpha():
            answer2.append(pairs2[i])
    
    pairs_counter1 = Counter(answer1)
    pairs_counter2 = Counter(answer2)

    intersection = pairs_counter1 & pairs_counter2
    union = pairs_counter1 | pairs_counter2
    
    son = sum(intersection.values())
    parent = sum(union.values())
    
    if son == 0 and parent == 0:
        return 65536
    
    result = int(son / parent * 65536)
   
    return result
    