--1)Retrieve the names of cities (city) and their corresponding countries (country) from the city table joined with the country table using LEFT JOIN.
SELECT city.city, country.country
FROM city
LEFT JOIN country ON city.country_id = country.country_id;

--2)Retrieve the first_name, last_name, and payment_id from the customer table joined with the payment table using RIGHT JOIN.
SELECT customer.first_name, customer.last_name, payment.payment_id
FROM customer
RIGHT JOIN payment ON customer.customer_id = payment.customer_id;

--3)Retrieve the first_name, last_name, and payment_id from the customer table joined with the payment table using FULL JOIN.
SELECT customer.first_name, customer.last_name, payment.payment_id
FROM customer
FULL JOIN payment ON customer.customer_id = payment.customer_id;
