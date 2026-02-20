SELECT 
    C.CAR_ID, 
    CASE
        WHEN COUNT(H.CAR_ID) > 0 THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY C
LEFT JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H
    ON C.CAR_ID = H.CAR_ID
    AND H.START_DATE <= '2022-10-16' 
    AND H.END_DATE >= '2022-10-16'
GROUP BY C.CAR_ID
ORDER BY C.CAR_ID DESC
# 2022년 10월 16일에 대여 중인 자동차인 경우 '대여중' 이라고 표시
# 대여 중이지 않은 자동차인 경우 '대여 가능'을 표시하는 컬럼 (컬럼명: AVAILABILITY)을 추가하여 자동차 ID와 AVAILABILITY 리스트를 출력하는 SQL문 작성
# 이때 반납 날짜가 2022년 10월 16일인 경우에도 '대여중'으로 표시해주시고 