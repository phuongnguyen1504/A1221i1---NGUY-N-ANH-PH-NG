use classicmodels;
create view customer_views as
select customerNumber,customerName, phone from customers;
drop view customer_views;
select * from customer_views;

create or replace view view_name as
select customerNumber,customerName, phone from customers
where city="Nantes";
drop view view_name;