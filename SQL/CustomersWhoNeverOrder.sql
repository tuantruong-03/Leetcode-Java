-- Example 1:

-- Input: 
-- Customers table:
-- +----+-------+
-- | id | name  |
-- +----+-------+
-- | 1  | Joe   |
-- | 2  | Henry |
-- | 3  | Sam   |
-- | 4  | Max   |
-- +----+-------+
-- Orders table:
-- +----+------------+
-- | id | customerId |
-- +----+------------+
-- | 1  | 3          |
-- | 2  | 1          |
-- +----+------------+
-- Output: 
-- +-----------+
-- | Customers |
-- +-----------+
-- | Henry     |
-- | Max       |
-- +-----------+

-- Solution
select c.name as Customers
from Customers c left join Orders o
on c.id = o.customerId
where o.id is null