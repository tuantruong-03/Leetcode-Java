-- Example 1:

-- Input: 
-- Employee table:
-- +----+-------+--------+--------------+
-- | id | name  | salary | departmentId |
-- +----+-------+--------+--------------+
-- | 1  | Joe   | 85000  | 1            |
-- | 2  | Henry | 80000  | 2            |
-- | 3  | Sam   | 60000  | 2            |
-- | 4  | Max   | 90000  | 1            |
-- | 5  | Janet | 69000  | 1            |
-- | 6  | Randy | 85000  | 1            |
-- | 7  | Will  | 70000  | 1            |
-- +----+-------+--------+--------------+
-- Department table:
-- +----+-------+
-- | id | name  |
-- +----+-------+
-- | 1  | IT    |
-- | 2  | Sales |
-- +----+-------+
-- Output: 
-- +------------+----------+--------+
-- | Department | Employee | Salary |
-- +------------+----------+--------+
-- | IT         | Max      | 90000  |
-- | IT         | Joe      | 85000  |
-- | IT         | Randy    | 85000  |
-- | IT         | Will     | 70000  |
-- | Sales      | Henry    | 80000  |
-- | Sales      | Sam      | 60000  |
-- +------------+----------+--------+
-- Explanation: 
-- In the IT department:
-- - Max earns the highest unique salary
-- - Both Randy and Joe earn the second-highest unique salary
-- - Will earns the third-highest unique salary

-- In the Sales department:
-- - Henry earns the highest salary
-- - Sam earns the second-highest salary
-- - There is no third-highest salary as there are only two employees

-- Solution
with RankedSalaryByDepartment as (select
    dep.name as Department
    , emp.name as Employee
    , emp.salary as Salary
    , dense_rank() over (partition by dep.id order by emp.salary desc) as "rank"
    from Employee emp inner join Department dep on emp.departmentId = dep.id)

select r.Department, r.Employee, r.Salary
from RankedSalaryByDepartment as r
where r.rank <= 3

-- Explanation: Use CTE, common table expression (CTE) is a named temporary result set that exists within the scope of a single statement and that can be referred to later within that statement, possibly multiple times. 
            with RankedSalaryByDepartment as 
                  (select
                    dep.name as Department
                    , emp.name as Employee
                    , emp.salary as Salary
                    , dense_rank() over (partition by dep.id order by emp.salary desc) as "rank"
                    from Employee emp inner join Department dep on emp.departmentId = dep.id)
            -- Rank the salary by the DeparmentId

