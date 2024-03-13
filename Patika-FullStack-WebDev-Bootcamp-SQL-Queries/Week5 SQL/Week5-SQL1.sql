--1)Sort the data in the film table based on the 'title' and 'description' columns.
SELECT title, description 
FROM film;

--2)Sort the data in all columns of the film table with the condition that the film length (length) is greater than 60 and less than 75.
SELECT * FROM film 
WHERE length > 60 AND length < 75;

--3)Sort the data in all columns of the film table with the conditions that the rental rate (rental_rate) is 0.99 and the replacement cost (replacement_cost) is either 12.99 or 28.99.
SELECT * FROM film 
WHERE rental_rate = 0.99 AND (replacement_cost = 12.99 OR replacement_cost = 28.99);

--4)What is the value in the 'last_name' column for the customer whose 'first_name' column value is 'Mary' in the customer table?
SELECT last_name FROM customer
WHERE first_name = 'Mary';

--5)Sort the data in the film table where the length is not greater than 50 and the rental_rate value is neither 2.99 nor 4.99.
SELECT * FROM film
WHERE NOT length > 50 AND NOT (rental_rate = 2.99 OR rental_rate = 4.99);