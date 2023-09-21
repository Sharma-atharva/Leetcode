# Write your MySQL query statement below
SELECT distinct viewer_id as id FROM Views 
where viewer_id=author_id ORDER BY viewer_id ASC;
