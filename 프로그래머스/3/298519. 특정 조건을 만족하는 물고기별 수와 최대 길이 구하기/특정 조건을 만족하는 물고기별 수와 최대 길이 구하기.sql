/* 
  고기를 종류별로 분류
   10cm이하의 물고기는 10cm로 취급
   물고기의 길이가 33cm이상인 물고기의 개수, 최대길이, 물고기 종류 출력
  물고기종류에 대해 오름차순
*/
SELECT
    COUNT(FISH_TYPE) AS FISH_COUNT,
    MAX(CASE 
            WHEN LENGTH IS NULL THEN 10
            WHEN LENGTH <= 10 THEN 10 
            ELSE LENGTH
        END) AS MAX_LENGTH, 
    FISH_TYPE
FROM FISH_INFO
GROUP BY FISH_TYPE
HAVING 
    AVG(CASE
            WHEN LENGTH IS NULL THEN 10
            WHEN LENGTH <= 10 THEN 10
            ELSE LENGTH
        END) >= 33
ORDER BY FISH_TYPE