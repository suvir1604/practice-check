-- Include table data insertion, updation, deletion and select scripts

---- ---------------------------------------------------------------
---- Adding Menu Items in MenuItem Table
---- ---------------------------------------------------------------
INSERT INTO menu_item
values
	(1, 'sandwich',99.0,'Yes','2017-03-15','main course','Yes'),
	(2, 'Burger', 129.0,'Yes','2017-12-23','main Course','No'),
	(3, 'Pizza', 149.0,'Yes','2018-08-21','main Course','No' ),
	(4, 'French Fries', 57.0, 'No', '2017-07-02','Starters','Yes'),
	(5,'Chocolate Brownie', 32.0, 'Yes', '2022-11-02','Dessert','Yes'); 
select * from menu_item;
 

---- ---------------------------------------------------------------
---- Updating menuitem in the MenuItem Table
---- ---------------------------------------------------------------
update menu_item
set  me_name='momos',me_price=150,me_active='Yes',me_date_of_launch='2020-04-14',me_category='Sides',me_free_delivery='No'
where me_id=1;
select * from menu_item;
 
---- ---------------------------------------------------------------
---- Adding User Details into User Table------------------------------
---- ---------------------------------------------------------------
INSERT INTO user(us_id,us_name)
VALUES
(1,'Hunny'),(2,'Sunny'); 

SELECT * FROM user;
---- ---------------------------------------------------------------
---- MenuItem  Table------------------------------
---- ---------------------------------------------------------------

SELECT me_name,me_free_delivery,me_price,me_category
FROM menu_item
WHERE me_active='Yes' AND me_date_of_launch < (SELECT(CURDATE()));
select * from menu_item;

---- ---------------------------------------------------------------
---- Adding Cart Item in the Cart table------------------------------
---- ---------------------------------------------------------------
INSERT INTO cart(ct_id,ct_us_id,ct_pr_id)
values
(11,1,1),(12,1,3),(13,1,2);
SELECT * FROM cart; 
---- ---------------------------------------------------------------
----  view cart table------------------------------
---- ---------------------------------------------------------------
SELECT me_name,me_free_delivery,me_price
FROM menu_item
inner join cart 
on ct_pr_id=me_id
where ct_us_id=1;

---- ---------------------------------------------------------------
----  Before Deletion------------------------------
---- ---------------------------------------------------------------
SELECT sum(me_price) as TotalPrice
FROM menu_item
inner join cart 
on ct_pr_id=me_id
where cart.ct_us_id=1;

---- ---------------------------------------------------------------
----  Deletion in the cart------------------------------
---- ---------------------------------------------------------------

delete from cart where ct_us_id=1 and ct_pr_id=2; 


SELECT * FROM cart; 













