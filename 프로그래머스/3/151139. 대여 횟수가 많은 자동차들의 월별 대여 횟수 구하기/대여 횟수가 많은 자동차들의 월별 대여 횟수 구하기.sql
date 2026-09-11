/*
    자동차 월별로 출력
    2022년 8월 ~ 2022년 10월 대여 횟수 출력
    대여 횟수 5회이상만 출력
    월을 기준으로 오름차순, 자동차 ID 내림차순
    
    월의 총 대여 횟수 0 제외
    
서브쿼리: 차 단위로 묶어서 5회 이상인 CAR_ID만 뽑기
바깥쿼리: 월+차 단위로 묶기 + CAR_ID가 위 명단에 있는지 검사
*/
SELECT
    MONTH(START_DATE) AS MONTH,
    CAR_ID,
    COUNT(*) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE (START_DATE >= '2022-08-01' AND START_DATE <= '2022-10-31') AND CAR_ID IN (
                    SELECT CAR_ID                                               FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
                    WHERE START_DATE >= '2022-08-01' AND START_DATE <= '2022-10-31'
                    GROUP BY CAR_ID
                    HAVING COUNT(*) >= 5
                   )
GROUP BY MONTH, CAR_ID
ORDER BY MONTH ASC, CAR_ID DESC