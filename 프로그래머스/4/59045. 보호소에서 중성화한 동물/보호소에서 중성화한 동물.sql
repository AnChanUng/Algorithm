SELECT A.ANIMAL_ID, A.ANIMAL_TYPE, A.NAME
FROM ANIMAL_INS A JOIN ANIMAL_OUTS B
ON A.ANIMAL_ID = B.ANIMAL_ID
WHERE A.SEX_UPON_INTAKE LIKE 'Intact %' 
AND (B.SEX_UPON_OUTCOME IN('Neutered Male') OR B.SEX_UPON_OUTCOME IN('Spayed Female'))
# WHERE (A.SEX_UPON_INTAKE = 'Intact Male' OR A.SEX_UPON_INTAKE = 'Intact Female')
# AND (B.SEX_UPON_OUTCOME = 'Neutered Male' OR B.SEX_UPON_OUTCOME = 'Spayed Female')
# 보호소에 들어올 당시에는 중성화 되지 않았지만, 보호소를 나갈 당시에는 중성화된 동물