SELECT memberList.id AS id,
       memberList.name AS name,
       memberList.gender AS gender,
       memberInfoList.manBirthday AS manBirthday,
       memberInfoList.womanBirthday AS womanBirthday,
       memberInfoList.manAdress AS manAdress,
       memberInfoList.womanAdress AS womanAdress
FROM   memberList
INNER JOIN memberInfoList
ON       memberList.id = memberInfoList.id
AND       memberList.gender = memberInfoList.gender
WHERE  memberList.number = /*number*/;