1# Write your MySQL query statement below
2SELECT 
3    u.name, 
4    IFNULL(SUM(r.distance), 0) AS travelled_distance
5FROM Users u
6LEFT JOIN Rides r 
7    ON u.id = r.user_id
8GROUP BY u.id, u.name
9ORDER BY 
10    travelled_distance DESC, 
11    u.name ASC;