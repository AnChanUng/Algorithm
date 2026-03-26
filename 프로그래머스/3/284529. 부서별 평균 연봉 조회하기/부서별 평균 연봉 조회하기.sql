-- 부서별 평균 연봉을 조회
SELECT A.DEPT_ID, A.DEPT_NAME_EN, ROUND(AVG(SAL), 0) AS AVG_SAL -- 부서 ID, 영문 부서명, 평균 연봉(평균연봉은 소수점 첫째 자리에서 반올림)
FROM HR_DEPARTMENT A JOIN HR_EMPLOYEES B
ON A.DEPT_ID = B.DEPT_ID
GROUP BY A.DEPT_ID, A.DEPT_NAME_EN
ORDER BY AVG_SAL DESC -- 부서별 평균 연봉을 기준으로 내림차순