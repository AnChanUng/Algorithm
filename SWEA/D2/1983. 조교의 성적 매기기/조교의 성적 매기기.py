grades = ["A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"]

t = int(input())
for test_case in range(1, t+1):
    n, k = map(int, input().split())

    array = []
    for i in range(n):
        mid, final, assign = map(int, input().split())
        score = mid*0.35 + final*0.45+assign*0.2
        array.append(score)

    target = array[k-1]
    array.sort(reverse=True)
    rate = n // 10
    ratio_score = array.index(target) // rate
    print(f'#{test_case}', grades[ratio_score])