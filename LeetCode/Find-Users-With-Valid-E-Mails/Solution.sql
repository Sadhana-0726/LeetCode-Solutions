1SELECT 
2    user_id, 
3    name, 
4    mail
5FROM Users
6WHERE mail REGEXP '^[a-zA-Z][a-zA-Z0-9_.-]*@leetcode\\.com$'
7  AND mail LIKE BINARY '%@leetcode.com';
8  