
/*

The Employee table holds all employees. Every employee has an Id, and there is also a column for the department Id.
+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
| 5  | Janet | 69000  | 1            |
| 6  | Randy | 85000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.
+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who earn the top three salaries in each of the department. 
For the above tables, your SQL query should return the following rows.
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| IT         | Randy    | 85000  |
| IT         | Joe      | 70000  |
| Sales      | Henry    | 80000  |
| Sales      | Sam      | 60000  |
+------------+----------+--------+

*/

/*

Solution: for each employee, check the employee table to ensure the number of others whose salary is higher is less than 3

*/

SELECT d.Name AS Department, E1.Name AS Employee, E1.Salary
FROM Department d
JOIN Employee E1
ON d.Id = E1.DepartmentId
WHERE 
    (SELECT COUNT(DISTINCT E2.Salary)
    FROM Employee E2
    WHERE E2.Salary > E1.Salary
    AND E2.DepartmentId = E1.DepartmentId) 
< 3
ORDER BY Department, Salary DESC




