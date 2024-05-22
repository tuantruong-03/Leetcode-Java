-- Example 1:

-- Input: 
-- Person table:
-- +----+------------------+
-- | id | email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- | 3  | john@example.com |
-- +----+------------------+
-- Output: 
-- +----+------------------+
-- | id | email            |
-- +----+------------------+
-- | 1  | john@example.com |
-- | 2  | bob@example.com  |
-- +----+------------------+
-- Explanation: john@example.com is repeated two times. We keep the row with the smallest Id = 1.

-- Solution:
delete from Person where id in (
        select personId from (select distinct p2.id as personId
            from Person p1 inner join Person p2 on p1.email = p2.email and p2.id > p1.id) as t
)

-- Explantion: 
        select personId from (select distinct p2.id as personId
            from Person p1 inner join Person p2 on p1.email = p2.email and p2.id > p1.id) as t
        -- This query will return the records where there are other people have the same email and the greater personId
        -- "Every derived table must have its own alias", so we have to name alias in subquery