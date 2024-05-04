for test_case in range(1, 11):
    t = int(input())
    array = [list(input()) for _ in range(100)]
    max_garo = 0
    max_sero = 0
    for i in range(100):
        result = ""
        total = ""
        for j in range(100):
            result += ''.join(array[i][j])
            if result == result[::-1]:
                max_garo = max(max_garo, len(result))

            total += ''.join(array[j][i])
            if total == total[::-1]:
                max_sero = max(max_sero, len(total))

    answer = max(max_garo, max_sero)
    print(answer)