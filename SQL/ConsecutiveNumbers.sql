-- Example 1:

-- Input: 
-- Logs table:
-- +----+-----+
-- | id | num |
-- +----+-----+
-- | 1  | 1   |
-- | 2  | 1   |
-- | 3  | 1   |
-- | 4  | 2   |
-- | 5  | 1   |
-- | 6  | 2   |
-- | 7  | 2   |
-- +----+-----+
-- Output: 
-- +-----------------+
-- | ConsecutiveNums |
-- +-----------------+
-- | 1               |
-- +-----------------+
-- Explanation: 1 is the only number that appears consecutively for at least three times.

-- Solution 1:
--     Explain:
        select l1.id from Logs l1, Logs l2
        where l1.num = l2.num && (l2.id = l1.id || l2.id = l1.id+1 || l2.id = l1.id + 2)
        group by l1.id
        having count(distinct l2.id) >= 3
        order by l1.id
--         If count >= 3, there are at least 3 consecutive numbers

select distinct num as ConsecutiveNums from Logs
where id in (
    select l1.id from Logs l1, Logs l2
    where l1.num = l2.num && (l2.id = l1.id || l2.id = l1.id+1 || l2.id = l1.id + 2)
    group by l1.id
    having count(distinct l2.id) >= 3
    order by l1.id
    )
order by id asc

-- Solution 2:
select distinct l1.num as ConsecutiveNums  
from Logs l1 inner join Logs l2 on l1.num = l2. num && l2.id = l1.id+1 
            inner join Logs l3 on l3.num = l1.num && l3.id = l2.id+1



