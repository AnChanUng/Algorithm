/*
    대장균 개체의 크기가 100 이하면 LOW
                      100초과면 1000이하면 MEDIUM
                      1000초과 HIGH
    
    대장균 개체의 id, size를 출력하는 SQL문
*/
SELECT ID, 
    CASE 
        WHEN SIZE_OF_COLONY <= 100 THEN 'LOW'
        WHEN SIZE_OF_COLONY > 100 AND SIZE_OF_COLONY <= 1000 THEN 'MEDIUM'
        ELSE 'HIGH'
    END AS SIZE
FROM ECOLI_DATA
