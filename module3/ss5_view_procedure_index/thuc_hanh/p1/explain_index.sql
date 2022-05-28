use classicmodels;
explain select * from customers
where customerName='Land of Toys Inc.';
alter table customers add index name_index(customerName);
alter table customers drop index name_index;
alter table customers add index idx_fullname(contactLastName,contactFirstName);
explain select * from customers where contactFirstName = 'Jean' or contactFirstName = 'King';
alter table customers drop index idx_fullname;