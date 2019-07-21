
/*

Table: Spending
+-------------+---------+
| Column Name | Type    |
+-------------+---------+
| user_id     | int     |
| spend_date  | date    |
| platform    | enum    | 
| amount      | int     |
+-------------+---------+
The table logs the spendings history of users that make purchases from an online shopping website 
which has a desktop and a mobile application.
(user_id, spend_date, platform) is the primary key of this table.
The platform column is an ENUM type of ('desktop', 'mobile').
Write an SQL query to find the total number of users and the total amount spent using mobile only, 
desktop only and both mobile and desktop together for each date.

The query result format is in the following example:
Spending table:
+---------+------------+----------+--------+
| user_id | spend_date | platform | amount |
+---------+------------+----------+--------+
| 1       | 2019-07-01 | mobile   | 100    |
| 1       | 2019-07-01 | desktop  | 100    |
| 2       | 2019-07-01 | mobile   | 100    |
| 2       | 2019-07-02 | mobile   | 100    |
| 3       | 2019-07-01 | desktop  | 100    |
| 3       | 2019-07-02 | desktop  | 100    |
+---------+------------+----------+--------+
Result table:
+------------+----------+--------------+-------------+
| spend_date | platform | total_amount | total_users |
+------------+----------+--------------+-------------+
| 2019-07-01 | desktop  | 100          | 1           |
| 2019-07-01 | mobile   | 100          | 1           |
| 2019-07-01 | both     | 200          | 1           |
| 2019-07-02 | desktop  | 100          | 1           |
| 2019-07-02 | mobile   | 100          | 1           |
| 2019-07-02 | both     | 0            | 0           |
+------------+----------+--------------+-------------+ 
On 2019-07-01, user 1 purchased using both desktop and mobile, 
user 2 purchased using mobile only and user 3 purchased using desktop only.
On 2019-07-02, user 2 purchased using mobile only, 
user 3 purchased using desktop only and no one purchased using both platforms.

*/

SELECT a.spend_date, a.platform, IFNULL(SUM(amount), 0) AS total_amount, COUNT(user_id) AS total_users
FROM (
    SELECT DISTINCT spend_date, 'desktop' AS platform FROM Spending
    UNION
    SELECT DISTINCT spend_date, 'mobile' AS platform FROM Spending
    UNION
    SELECT DISTINCT spend_date, 'both' AS platform FROM Spending
) a
LEFT JOIN (
    SELECT spend_date, user_id, 
           IF(desktop_amount > 0, IF(mobile_amount > 0 , 'both', 'desktop'), 'mobile') AS platform, 
           (desktop_amount + mobile_amount) AS amount
    FROM (
        SELECT spend_date, user_id, 
               SUM(CASE platform WHEN 'desktop' THEN amount ELSE 0 END) AS desktop_amount,
               SUM(CASE platform WHEN 'mobile' THEN amount ELSE 0 END) AS mobile_amount
        FROM Spending
        GROUP BY spend_date, user_id
    ) tmp
) b
ON a.spend_date = b.spend_date AND a.platform = b.platform
GROUP BY spend_date, platform



