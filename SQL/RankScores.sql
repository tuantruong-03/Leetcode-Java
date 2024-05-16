-- Example 1:

-- Input: 
-- Scores table:
-- +----+-------+
-- | id | score |
-- +----+-------+
-- | 1  | 3.50  |
-- | 2  | 3.65  |
-- | 3  | 4.00  |
-- | 4  | 3.85  |
-- | 5  | 4.00  |
-- | 6  | 3.65  |
-- +----+-------+
-- Output: 
-- +-------+------+
-- | score | rank |
-- +-------+------+
-- | 4.00  | 1    |
-- | 4.00  | 1    |
-- | 3.85  | 2    |
-- | 3.65  | 3    |
-- | 3.65  | 3    |
-- | 3.50  | 4    |
-- +-------+------+

-- Solution 1: 
select s1.score, count(distinct s2.score) as 'rank' from Scores s1, Scores s2
where s1.score < s2.score
group by s1.id
order by 1 desc
-- Explain: 
--     s1.id | s1.score | s2.score
--        2        3.65     3.65     
--        2        3.65     3.85
--        2        3.65     4.00
--     Look at the table, the score 3.65 is less than or equal to the total of 3 values (3.65, 3.85, 4.00)
--     Therefore, the score 3.65 is considered to have a rank of 3

-- Solution 2: denserank()
select score,
dense_rank() over (order by score desc ) as "rank"
from Scores
