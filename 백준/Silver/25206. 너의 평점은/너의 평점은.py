n = 20
result = 0
total_num = 0
for _ in range(n):
    sbject_name, num, grade = input().split()
    num = float(num)

    if grade == "A+":
        result += 4.5 * num

    elif grade == "A0":
        result += 4.0 * num

    elif grade == "B+":
        result += 3.5 * num

    elif grade == "B0":
        result += 3.0 * num

    elif grade == "C+":
        result += 2.5 * num

    elif grade == "C0":
        result += 2.0 * num

    elif grade == "D+":
        result += 1.5 * num

    elif grade == "D0":
        result += 1.0 * num

    elif grade == "F":
        result += 0 * num

    else:
        continue

    total_num += num

print(result / total_num)