
/*

Given a Weather table, write a SQL query to find all dates' Ids with higher temperature 
compared to its previous (yesterday's) dates.
+---------+------------------+------------------+
| Id(INT) | RecordDate(DATE) | Temperature(INT) |
+---------+------------------+------------------+
|       1 |       2015-01-01 |               10 |
|       2 |       2015-01-02 |               25 |
|       3 |       2015-01-03 |               20 |
|       4 |       2015-01-04 |               30 |
+---------+------------------+------------------+
For example, return the following Ids for the above Weather table:
+----+
| Id |
+----+
|  2 |
|  4 |
+----+

*/

/*

TO_DAYS(x.DATE): return the number of days between from year 0 to date DATE

*/

SELECT W2.Id
FROM Weather W1, Weather W2
WHERE W1.Temperature < W2.Temperature
AND TO_DAYS(W1.RecordDate) = TO_DAYS(W2.RecordDate) - 1



