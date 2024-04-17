numbers = list(map(int, input().split()))

ascending = [i for i in range(1, 9)]

descending = [i for i in range(8, 0, -1)]

if numbers == ascending:
    print("ascending")
elif numbers == descending:
    print("descending")
else:
    print("mixed")