from itertools import product

def solution(word):
    
    words = []
    moeum = ['A', 'E', 'I', 'O', 'U']
    for i in range(1, 6):
        for j in product(moeum, repeat=i):
            words.append(''.join(list(j)))
            print(j)
    words.sort()
    return words.index(word)+1