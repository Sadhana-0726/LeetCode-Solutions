1# Write your MySQL query statement below
2(
3    SELECT u.name AS results
4    FROM MovieRating mr
5    JOIN Users u ON mr.user_id = u.user_id
6    GROUP BY mr.user_id
7    ORDER BY COUNT(mr.movie_id) DESC, u.name ASC
8    LIMIT 1
9)
10UNION ALL
11(
12    SELECT m.title AS results
13    FROM MovieRating mr
14    JOIN Movies m ON mr.movie_id = m.movie_id
15    WHERE mr.created_at BETWEEN '2020-02-01' AND '2020-02-29'
16    GROUP BY mr.movie_id
17    ORDER BY AVG(mr.rating) DESC, m.title ASC
18    LIMIT 1
19);