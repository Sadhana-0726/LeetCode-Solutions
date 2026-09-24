1# Write your MySQL query statement below
2SELECT 
3    p.product_id, 
4    IFNULL(ROUND(SUM(p.price * u.units) / SUM(u.units), 2), 0) AS average_price
5FROM Prices p
6LEFT JOIN UnitsSold u 
7    ON p.product_id = u.product_id 
8   AND u.purchase_date BETWEEN p.start_date AND p.end_date
9GROUP BY p.product_id;