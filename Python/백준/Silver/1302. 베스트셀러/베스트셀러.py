n = int(input())

dic = {}
for i in range(n):
    word = input()

    if word in dic:
        dic[word] +=1
    else:
        dic[word] = 1

sorted_dic = sorted(dic.items(), key=lambda x: (-x[1], x[0]))

print(sorted_dic[0][0])