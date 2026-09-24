1# Write your MySQL query statement below
2SELECT person_name
3FROM (
4    SELECT 
5        person_name,
6        SUM(weight) OVER (ORDER BY turn) AS total_weight
7    FROM Queue
8) q
9WHERE total_weight <= 1000
10ORDER BY total_weight DESC
11LIMIT 1;