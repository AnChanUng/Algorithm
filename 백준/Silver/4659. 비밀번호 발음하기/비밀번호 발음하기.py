moeum = ['a', 'e', 'i', 'o', 'u']

while True:
    word = input().strip()

    if word == 'end':
        break
    
    has_vowel = False
    cnt1 = 0
    cnt2 = 0
    acceptable = True
    for i in range(len(word)):

        if word[i] in moeum:
            cnt1 += 1
            cnt2 = 0
            has_vowel = True
            if cnt1 >= 3:
                acceptable = False
                break

        else: 
            cnt2 += 1
            cnt1 = 0
            if cnt2 >= 3:
                acceptable = False
                break
        
        if i >0 and word[i] == word[i-1]:
            if word[i] not in ('e', 'o'):
                acceptable = False
                break
    
    if not has_vowel:
        acceptable = False
    
    if acceptable:
        print(f"<{word}> is acceptable.")
    else:
        print(f"<{word}> is not acceptable.")