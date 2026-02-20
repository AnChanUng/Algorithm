SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME # 동물의 아이디와 생물 종, 이름
FROM ANIMAL_INS A JOIN ANIMAL_OUTS B
ON A.ANIMAL_ID = B.ANIMAL_ID
# 보호소에서 중성화 수술을 거친 동물 정보
WHERE (A.SEX_UPON_INTAKE = 'Intact Male' OR A.SEX_UPON_INTAKE = 'Intact Female')
AND (B.SEX_UPON_OUTCOME = 'Neutered Male' OR B.SEX_UPON_OUTCOME = 'Spayed Female')
# 보호소에 들어올 당시에는 중성화 되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물