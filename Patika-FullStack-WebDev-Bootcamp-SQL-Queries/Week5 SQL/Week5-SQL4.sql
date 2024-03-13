--1)List the distinct values in the 'replacement_cost' column of the film table in the database.
SELECT DISTINCT replacement_cost FROM film;

--2)How many different values are there in the 'replacement_cost' column of the film table?
SELECT COUNT (DISTINCT replacement_cost) FROM film;

--3)How many movies in the film table start with the letter 'T' in their title and have a rating of 'G'
SELECT COUNT (title) FROM film
WHERE title LIKE 'T%' AND rating = 'G';

--4)How many country names (country) in the country table consist of 5 characters?
SELECT COUNT (country) FROM country
WHERE country LIKE '_____';

--5)How many city names in the city table end with the letter 'R' or 'r'
SELECT COUNT (city) FROM city
WHERE city ILIKE '%R';