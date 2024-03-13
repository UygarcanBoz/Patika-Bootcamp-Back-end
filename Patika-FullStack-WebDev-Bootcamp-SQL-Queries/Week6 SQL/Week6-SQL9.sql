--1)List the top 4 films from the 'film' table that start with the letter 'K', ordered by length in descending order and replacement_cost in ascending order.
SELECT title, length, replacement_cost
FROM film
WHERE title LIKE 'K%'
ORDER BY length DESC, replacement_cost ASC
LIMIT 4;

--2)Which rating category contains the maximum number of films in the 'film' table?
SELECT rating, COUNT(*) AS film_count
FROM film
GROUP BY rating
ORDER BY film_count DESC
LIMIT 1;

--3)What is the name of the customer who has made the most purchases in the 'customer' table?
SELECT first_name, last_name, COUNT(*) AS purchase_count
FROM customer
JOIN payment ON customer.customer_id = payment.customer_id
GROUP BY customer.customer_id, first_name, last_name
ORDER BY purchase_count DESC
LIMIT 1;

--4)List the category names and the number of films per category from the 'category' table.
SELECT category.name AS category_name, COUNT(film_category.film_id) AS film_count
FROM category
JOIN film_category ON category.category_id = film_category.category_id
GROUP BY category.name
ORDER BY film_count DESC;

--5)How many films in the 'film' table have at least 4 occurrences of the letter 'e' or 'E' in their names?
SELECT COUNT(*) AS film_count
FROM film
WHERE LENGTH(title) - LENGTH(REPLACE(title, 'e', '')) >= 4 OR LENGTH(title) - LENGTH(REPLACE(title, 'E', '')) >= 4;
