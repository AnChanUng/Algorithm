from collections import Counter
def solution(k, tangerine):
    # 귤 크기별 수량에 따른 정렬
    sort_list = sorted(Counter(tangerine).items(), key=lambda pair: pair[1], reverse=True)
    
    # '종류 수'와 '종류 별 수량' for loop
    for i, t in enumerate(sort_list, start=1):
        # 수량이 많은 귤부터 담기
        k -= t[1]
        # 상자가 가득차면 담은 횟수(인덱스) 리턴
        if(k <= 0):
            return i