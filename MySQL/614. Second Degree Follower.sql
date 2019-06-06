
/*

In facebook, there is a follow table with two columns: followee, follower.
Please write a sql query to get the amount of each follower’s follower if he/she has one.

For example:
+-------------+------------+
| followee    | follower   |
+-------------+------------+
|     A       |     B      |
|     B       |     C      |
|     B       |     D      |
|     D       |     E      |
+-------------+------------+
should output:
+-------------+------------+
| follower    | num        |
+-------------+------------+
|     B       |  2         |
|     D       |  1         |
+-------------+------------+

*/

SELECT DISTINCT follower, num 
FROM follow,
    (SELECT followee, COUNT(DISTINCT follower) AS num FROM follow
    GROUP BY followee) as tmp
WHERE follower = tmp.followee
ORDER BY follower


