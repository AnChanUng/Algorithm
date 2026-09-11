/*
    CAR_ID,
     2022년 10월 16일에 대여중 -> 대여중 표시
     2022년 10월 16일에 대여X -> 대여 가능 AS AVAILABILITY 출력
    결과 자동차 ID 내림차순
*/
SELECT CAR_ID,
        MAX(CASE 
            WHEN START_DATE	<= '2022-10-16' AND END_DATE >= '2022-10-16' THEN '대여중'
            ELSE '대여 가능'
        END) AS VAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
ORDER BY CAR_ID DESC