
/*

The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.
+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.
+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who have the highest salary in each of the departments. 
For the above tables, Max has the highest salary in the IT department, Henry has the highest salary in the Sales department.
+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+

*/

SELECT d.Name AS Department, E1.Name AS Employee, E1.Salary
FROM Employee E1, 
    Department d, 
    (SELECT DepartmentId, MAX(Salary) AS Salary FROM Employee GROUP BY DepartmentId) E2
WHERE E1.DepartmentId = E2.DepartmentId
AND E1.Salary = E2.Salary
AND E1.DepartmentId = d.Id




