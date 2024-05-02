t = int(input())
for test_case in range(1, t+1):
    word = input()
    
    for i in range(1, 31):
        if word[:i] == word[i:2*i]:
            print(f'#{test_case} {i}')
            break

