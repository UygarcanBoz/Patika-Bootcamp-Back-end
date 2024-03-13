--1)Retrieve the names of cities (city) and their corresponding countries (country) from the city table joined with the country table using INNER JOIN.
SELECT city.city, country.country
FROM city
INNER JOIN country ON city.country_id = country.country_id;

--2)Retrieve the first_name, last_name, and payment_id from the customer table joined with the payment table using INNER JOIN.
SELECT customer.first_name, customer.last_name, payment.payment_id
FROM customer
INNER JOIN payment ON customer.customer_id = payment.customer_id;

--3)Retrieve the first_name, last_name, and rental_id from the customer table joined with the rental table using INNER JOIN.
SELECT customer.first_name, customer.last_name, rental.rental_id
FROM customer
INNER JOIN rental ON customer.customer_id = rental.customer_id;
