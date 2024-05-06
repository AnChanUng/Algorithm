t = int(input())
for test_case in range(1, t+1):
    n, k = map(int, input().split())
    k_numbers = list(map(int, input().split()))

    students = [i for i in range(1, n+1)]

    for i in k_numbers:
        students.remove(i)

    print(f'#{test_case}', *students)