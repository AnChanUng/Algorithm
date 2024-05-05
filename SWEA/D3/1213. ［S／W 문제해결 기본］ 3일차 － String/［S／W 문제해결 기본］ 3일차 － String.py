for test_case in range(1, 11):
    t = int(input())
    find = input()
    word = input()
    cnt = 0
    for i in range(len(word)-len(find)+1):
        result = ""
        num = len(find)
        result += "".join(word[i:i+num])

        if result == find:
            cnt += 1
    print(f'#{test_case}', cnt)