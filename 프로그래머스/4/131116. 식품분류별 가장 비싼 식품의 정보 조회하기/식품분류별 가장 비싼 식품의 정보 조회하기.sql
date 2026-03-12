SELECT A.CATEGORY, A.PRICE AS MAX_PRICE, A.PRODUCT_NAME -- 가격이 제일 비싼 식품의 분류, 가격, 이름
FROM FOOD_PRODUCT A
WHERE CATEGORY IN ('과자', '국', '김치', '식용유') -- 식품분류가 '과자', '국', '김치', '식용유'인 경우
AND A.PRICE = (
    SELECT MAX(B.PRICE)
    FROM FOOD_PRODUCT B
    WHERE A.CATEGORY = B.CATEGORY
)
GROUP BY CATEGORY, PRICE, PRODUCT_NAME -- 식품분류별
ORDER BY PRICE DESC -- 식품 가격을 기준으로 내림차순 정렬
