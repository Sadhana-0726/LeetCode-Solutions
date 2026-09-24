1# Write your MySQL query statement below
2SELECT 
3    sell_date,
4    COUNT(DISTINCT product) AS num_sold,
5    GROUP_CONCAT(DISTINCT product ORDER BY product ASC SEPARATOR ',') AS products
6FROM Activities
7GROUP BY sell_date
8ORDER BY sell_date ASC;