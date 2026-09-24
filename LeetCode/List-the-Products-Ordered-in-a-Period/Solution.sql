1# Write your MySQL query statement below
2SELECT 
3    p.product_name, 
4    SUM(o.unit) AS unit
5FROM Products p
6JOIN Orders o 
7    ON p.product_id = o.product_id
8WHERE DATE_FORMAT(o.order_date, '%Y-%m') = '2020-02'
9GROUP BY p.product_id
10HAVING SUM(o.unit) >= 100;