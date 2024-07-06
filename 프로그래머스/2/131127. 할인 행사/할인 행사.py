from collections import Counter
def solution(want, number, discount):
    answer = 0
    dic = {}
    for w, n in zip(want, number):
        dic[w] = n
    
    for i in range(len(discount)):
        if dic == Counter(discount[i:i+10]):
            answer += 1
    
    return answer