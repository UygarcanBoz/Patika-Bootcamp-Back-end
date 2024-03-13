--1)Retrieve all data from the first_name column in the actor table, combined with all data from the first_name column in the customer table.
SELECT first_name FROM actor
UNION
SELECT first_name FROM customer;

--2)Retrieve the common data from the first_name column in the actor table and the first_name column in the customer table.
SELECT first_name FROM actor
INTERSECT
SELECT first_name FROM customer;

--3)Retrieve the data from the first_name column in the actor table that is not present in the first_name column of the customer table.
SELECT first_name FROM actor
EXCEPT
SELECT first_name FROM customer;

--4)Retrieve the unique data from the first_name column in both the actor and customer tables, including common and distinct values.
SELECT first_name FROM actor
UNION
SELECT first_name FROM customer
INTERSECT
SELECT first_name FROM actor
INTERSECT
SELECT first_name FROM customer
EXCEPT
SELECT first_name FROM actor
EXCEPT
SELECT first_name FROM customer;
