--1)What is the average of values in the 'rental_rate' column of the film table?
SELECT AVG (rental_rate) FROM film;

--2)How many films in the film table start with the letter 'C'?
SELECT COUNT (title) FROM film
WHERE title LIKE 'C%';

--3)For the films in the film table with a 'rental_rate' value equal to 0.99, what is the length of the longest film in minutes?
SELECT MAX (length) FROM film
WHERE rental_rate = 0.99;

--4)How many distinct replacement_cost values are there for films in the film table with a length greater than 150 minutes?
SELECT COUNT (DISTINCT replacement_cost) FROM film
WHERE length > 150;