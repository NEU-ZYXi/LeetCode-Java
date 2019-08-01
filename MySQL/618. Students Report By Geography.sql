
/*

A U.S graduate school has students from Asia, Europe and America. 
The students' location information are stored in table student as below.
| name   | continent |
|--------|-----------|
| Jack   | America   |
| Pascal | Europe    |
| Xi     | Asia      |
| Jane   | America   |
Pivot the continent column in this table so that each name is sorted alphabetically 
and displayed underneath its corresponding continent.
The output headers should be America, Asia and Europe respectively.
It is guaranteed that the student number from America is no less than either Asia or Europe.
 
For the sample input, the output is:
| America | Asia | Europe |
|---------|------|--------|
| Jack    | Xi   | Pascal |
| Jane    |      |        |

*/

SELECT a.name AS America, b.name AS Asia, c.name AS Europe
FROM (
    SELECT @r1 := @r1 + 1 AS id, name 
    FROM student, (SELECT @r1 := 0) init 
    WHERE continent = 'America' 
    ORDER BY name
) a
LEFT JOIN (
    SELECT @r2 := @r2 + 1 AS id, name 
    FROM student, (SELECT @r2 := 0) init 
    WHERE continent = 'Asia' 
    ORDER BY name
) b
ON a.id = b.id
LEFT JOIN (
    SELECT @r3 := @r3 + 1 AS id, name 
    FROM student, (SELECT @r3 := 0) init 
    WHERE continent = 'Europe' 
    ORDER BY name
) c
ON a.id = c.id
OR b.id = c.id




