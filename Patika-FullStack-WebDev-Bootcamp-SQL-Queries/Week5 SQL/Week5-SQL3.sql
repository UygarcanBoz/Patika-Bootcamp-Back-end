--1)Retrieve the country names from the 'country' column in the 'country' table, where the names start with the character 'A' and end with the character 'a'.
SELECT country FROM country
WHERE country LIKE 'A%a';

--2)Retrieve the country names from the 'country' column in the 'country' table, where the names consist of at least 6 characters and end with the character 'n'.
SELECT country FROM country
WHERE country LIKE '_____%n';

--3)Retrieve the movie titles from the 'title' column in the 'film' table, where the titles contain the character 'T' at least 4 times, regardless of case sensitivity.
SELECT title FROM film
WHERE title ILIKE '%t%t%t%t%';

--4)Retrieve data from all columns in the 'film' table where the 'title' starts with the character 'C,' has a length greater than 90, and has a 'rental_rate' of 2.99.
SELECT * FROM film
WHERE title LIKE 'C%' AND length > 90 AND rental_rate = 2.99;