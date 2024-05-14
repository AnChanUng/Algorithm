word = input()
ucpc = ["U", "C", "P", "C"]
flag = True

for i in range(len(ucpc)):
    if ucpc[i] in word:
        flag = True
        idx = word.find(ucpc[i])
        word = word[idx+1:]
    else:
        flag = False
        break

if flag == True:
    print("I love UCPC")
else:
    print("I hate UCPC")