--1)How many films in the 'film' table have a length greater than the average film length?
SELECT COUNT(*) FROM film 
WHERE length > (SELECT AVG(length) FROM film);

--2)How many films in the 'film' table have the highest rental_rate value?
SELECT COUNT(*) FROM film 
WHERE rental_rate = (SELECT MAX(rental_rate) FROM film);

--3)List the films in the 'film' table with the lowest rental_rate and the lowest replacement_cost values.
SELECT * FROM film
WHERE rental_rate = (SELECT MIN(rental_rate) FROM film)
AND replacement_cost = (SELECT MIN(replacement_cost) FROM film);

--4)List the customers with the highest number of transactions in the 'payment' table.
SELECT customer_id, COUNT(*) AS transaction_count
FROM payment
GROUP BY customer_id
ORDER BY transaction_count DESC
LIMIT 5;
