1SELECT 
2    DATE_FORMAT(trans_date, '%Y-%m') AS month,
3    country,
4    COUNT(id) AS trans_count,
5    SUM(IF(state = 'approved', 1, 0)) AS approved_count,
6    SUM(amount) AS trans_total_amount,
7    SUM(IF(state = 'approved', amount, 0)) AS approved_total_amount
8FROM Transactions
9GROUP BY month, country;