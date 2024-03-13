--1)List the top 5 films in the film table that end with the letter 'n' in their title, based on the longest length.
SELECT title, length FROM film
WHERE title LIKE '%n'
ORDER BY length DESC
LIMIT 5;

--2)List the bottom 5 films (6th to 10th) in the film table that end with the letter 'n' in their title, based on the shortest length.
SELECT title, length FROM film
WHERE title LIKE '%n'
ORDER BY length ASC
OFFSET 5 LIMIT 5;
--or LIMIT 5 OFFSET 5;


--3)Sort the data in the customer table based on the last_name column in descending order and list the first 4 records, considering only those with store_id equal to 1.
SELECT store_id, last_name FROM customer
WHERE store_id = 1
ORDER BY last_name DESC
LIMIT 4;