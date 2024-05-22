-- Example 1:

-- Input: 
-- Weather table:
-- +----+------------+-------------+
-- | id | recordDate | temperature |
-- +----+------------+-------------+
-- | 1  | 2015-01-01 | 10          |
-- | 2  | 2015-01-02 | 25          |
-- | 3  | 2015-01-03 | 20          |
-- | 4  | 2015-01-04 | 30          |
-- +----+------------+-------------+
-- Output: 
-- +----+
-- | id |
-- +----+
-- | 2  |
-- | 4  |
-- +----+
-- Explanation: 
-- In 2015-01-02, the temperature was higher than the previous day (10 -> 25).
-- In 2015-01-04, the temperature was higher than the previous day (20 -> 30).

-- Solution
select w2.id as Id
from Weather w1 inner join Weather w2 
on date_sub(w2.recordDate, interval 1 day) = w1.recordDate and w2.temperature > w1.temperature
-- Explaination: date_sub(currentDate, interval 1 day) to get the previous date of "currentDate"
--               Note: we can replace "day" with "month", "year"