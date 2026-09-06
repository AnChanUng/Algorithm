/*
    가장 많이 쓴 회원 아이디 하나 뽑기
    - 회원 별 리 뷰 개수 세기
    - 최대값 구하기
    가장많이 작성한 사람의 조건 출력
*/
SELECT A.MEMBER_NAME, B.REVIEW_TEXT, B.REVIEW_DATE
FROM MEMBER_PROFILE A JOIN REST_REVIEW B
ON A.MEMBER_ID = B.MEMBER_ID
WHERE A.MEMBER_ID = (SELECT MEMBER_ID
                     FROM REST_REVIEW
                     GROUP BY MEMBER_ID
                     ORDER BY COUNT(MEMBER_ID) DESC LIMIT 1)   
ORDER BY B.REVIEW_DATE, B.REVIEW_TEXT