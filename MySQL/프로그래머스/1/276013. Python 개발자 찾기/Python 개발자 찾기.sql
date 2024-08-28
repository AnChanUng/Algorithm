SELECT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM DEVELOPER_INFOS
WHERE skill_1 = 'python' or skill_2 = 'python' or skill_3 = 'python'
ORDER BY ID ASC;