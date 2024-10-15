n = int(input())
student = int(input())  # 추천 학생 수
number = list(map(int, input().split()))
recommend = [0] * 101
picture = []

for i in range(student):
    if number[i] in picture:
        # 4. 현재 사진이 게시된 학생이 다른 학생의 추천을 받은 경우 추천 받은 횟수만 증가
        recommend[number[i]] += 1
    elif len(picture) < n:
        # 비어있는 사진틀이 있는 경우 새로운 학생 추가
        picture.append(number[i])
        recommend[number[i]] += 1
    else:
        # 3-1. 비어있는 사진틀이 없는 경우 추천 받은 횟수가 가장 적은 사진 삭제
        min_recommend = min(recommend[stu] for stu in picture)
        candidates = [stu for stu in picture if recommend[stu] == min_recommend]

        # 3-2. 추천 받은 횟수가 가장 적은 학생이 두명 이상이면 가장 오래된 사진 삭제
        if len(candidates) > 1:
            student_to_remove = candidates[0]  # 가장 오래된 학생
        else:
            student_to_remove = candidates[0]

        picture.remove(student_to_remove)
        recommend[student_to_remove] = 0  # 5. 사진틀에서 삭제되면 추천 횟수 초기화

        # 새로운 학생 추가
        picture.append(number[i])
        recommend[number[i]] += 1

# 최종적으로 사진틀에 남은 학생들을 오름차순으로 정렬하여 출력
picture.sort()
print(' '.join(map(str, picture)))