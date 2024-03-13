--1)Group the films in the film table by their rating values.
SELECT rating, COUNT(*) AS film_count
FROM film
GROUP BY rating;

--2)List the replacement_cost values and their corresponding film counts for those replacement_cost values where the number of films is greater than 50 when grouping films by the replacement_cost column in the film table.
SELECT replacement_cost, COUNT(*) AS film_count
FROM film
GROUP BY replacement_cost
HAVING COUNT(*) > 50
ORDER BY replacement_cost;

--3)What are the customer counts for each store_id value in the customer table?
SELECT store_id, COUNT(*) AS customer_count
FROM customer
GROUP BY store_id;

--4)After grouping the city data in the city table by the country_id column, share the country_id information that has the highest number of cities and the corresponding city count.
SELECT country_id, COUNT(*) AS city_count
FROM city
GROUP BY country_id
ORDER BY city_count DESC
LIMIT 1;
