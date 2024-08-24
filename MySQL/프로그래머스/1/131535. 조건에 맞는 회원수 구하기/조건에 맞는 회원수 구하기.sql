-- 코드를 입력하세요
SELECT count(*) AS USERS
FROM USER_INFO
WHERE DATE_FORMAT(JOINED, '%Y') = '2021' and (age >= 20 and age <= 29);