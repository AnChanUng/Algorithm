/*
    대중균 개체 크기 내림차순 정렬
    개체의 크기가 를 아래와 같이 분류
     상위 0 ~ 25% CRITICAL ->  ID가 ID의 개수 x 0.25
     상위 26 ~ 50% HIGH ->  ID가 ID의 개수 x 0.50
     상위 51 ~ 75 MEDIUM ->  ID가 ID의 개수 x 0.75
     상위 76 ~ 100 LOW -.  ID가 ID의 개수 x 1
     대장균 개체의 ID와 분류된 이름을 출력
    개체 ID에 대해 오름차순
*/
SELECT 
    ID,
    CASE 
        WHEN RNUM <= TOTAL * 0.25 THEN 'CRITICAL'
        WHEN RNUM <= TOTAL * 0.50 THEN 'HIGH'
        WHEN RNUM <= TOTAL * 0.75 THEN 'MEDIUM'
        ELSE 'LOW'
    END AS COLONY_NAME
FROM ( 
    SELECT 
        ID, 
        ROW_NUMBER() OVER (ORDER BY SIZE_OF_COLONY DESC) AS RNUM, COUNT(*) OVER () AS TOTAL
    FROM ECOLI_DATA
) AS T
ORDER BY ID ASC