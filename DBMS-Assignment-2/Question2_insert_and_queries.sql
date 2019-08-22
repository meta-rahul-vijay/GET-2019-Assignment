use store_front;

-- 2.a Insert sample data in StoreFront tables by using SQL files.


-- insert data in admin

INSERT INTO admin_details VALUES (1,'admin1','admin@gmail.com');

-- insert data in shopper

INSERT INTO shopper VALUES 
(2,'mahendar',1234567890,'mahendar@gmail.com'),
(3,'ajay',1234567890,'ajay@gmail.com') ,
(4,'aman',1234567890,'aman@gmail.com') ,
(5,'anmol',1234567890,'anmol@gmail.com') ,
(6,'vinod',1234567890,'vinod@gmail.com') ,
(7,'shobit',1234567890,'shobit@gmail.com');

-- insert into shopper_address

INSERT INTO shopper_address VALUES
(2,'udaipur') ,
(2,'jaipur') ,
(3,'bangalore') ,
(3,'delhi') ,
(4,'jodhpur') ,
(5,'bikaner') ,
(6,'jaipur') ,
(7,'udaipur') ;


/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE category;
*/

-- insert data in category

INSERT INTO category(category_name,parent_id, parent_category) VALUES
('electronics',null,null),
('fashion',null,null),
('mobile',1,'electronics'),
('tv',1,'electronics'),
('trimmer',1,'electronics'),
('men_wear',2,'fashion'),
('shirt',6,'men_wear'),
('trouser',6,'men_wear'),
('shoes',6,'men_wear') ,
('women_wear',2,'fashion') ,
('top',10,'women_wear') ,
('jeans',10,'women_wear');

/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE product;
*/

-- insert data in product

INSERT INTO product(product_name,price,stock,date_added,category_id,isactive) VALUES
('mi7',12500,5,'2019-08-10 14:29:36',3,true),
('oppo f1',15000,5,'2019-08-10 14:45:36',3,true),
('phillips',1250,5,'2019-08-10 15:29:36',5,true),
('nova',2000,5,'2019-08-11 11:20:36',5,true),
('LP',1100,5,'2019-08-11 11:30:36',7,true),
('tommy',13000,5,'2019-08-11 12:20:36',7,true),
('hankey',450,5,'2019-08-12 10:20:36',6,true),
('monclear',12000,5,'2019-08-11 13:45:36',8,true),
('nike',17000,5,'2019-08-12 10:20:36',8,true),
('nike',17000,5,'2019-08-12 10:20:36',9,true),
('us polo',2200,5,'2019-08-12 11:20:36',9,true),
('converse',2100,5,'2019-08-12 12:20:36',9,true) ,
('LG',15000,5,'2019-08-12 13:20:36',4,true) ,
('sony',18000,5,'2019-08-12 14:20:36',4,true) ,
('GAP',2000,5,'2019-08-12 15:20:36',8,true),
('jack',2000,5,'2019-08-12 15:50:36',8,true),
('wtop1',800,5,'2019-08-13 09:20:36',11,true),
('wtop2',900,5,'2019-08-13 10:20:36',11,true),
('wjeans1',2000,5,'2019-08-13 11:20:36',12,true) ,
('wjeans2',2000,5,'2019-08-13 12:20:36',12,true) ,
('hankey',50,5,'2019-08-12 10:20:36',12,true) ;

/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE images;
*/

-- insert into images 
 INSERT INTO images VALUES 
 (1,'/image1.1') ,
 (1,'/image1.2') ,
 (2,'/image2.1') ,
 (2,'/image2.1') ,
 (3,'/image3.1') ,
 (5,'/image5.1') ,
 (6,'/image6.1') ,
 (7,'/image7.1') ,
 (8,'/image8.1') ,
 (9,'/image9.1') ,
 (10,'/image10.1') ,
 (11,'/image11.1') ,
 (12,'/image12.1') ,
 (13,'/image13.1') ,
 (14,'/image14.1') ,
 (15,'/image15.1') ,
 (16,'/image16.1') ,
 (18,'/image18.1') ;

/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE cart;
*/

-- insert into cart

INSERT INTO cart(cart_id,product_id,quantity,price,date_added,item_status) VALUES
(2,2,3,(select price from product where product_id=2)*3,'2019-08-01 11:20:36',null) ,
(2,3,2,(select price from product where product_id=3)*2,'2019-08-01 09:20:36',null) ,
(3,5,1,(select price from product where product_id=5)*1,'2019-08-02 10:20:36',null) ,
(3,1,2,(select price from product where product_id=1)*2,'2019-08-02 11:20:36',null) ,
(3,4,1,(select price from product where product_id=4)*1,'2019-08-03 12:20:36',null) ,
(4,9,2,(select price from product where product_id=9)*2,'2019-08-03 13:20:36',null) ,
(5,10,1,(select price from product where product_id=10)*1,'2019-08-03 14:20:36',null) ,
(5,12,1,(select price from product where product_id=12)*1,'2019-08-04 08:20:36',null) ,
(6,1,2,(select price from product where product_id=1)*2,'2019-07-04 10:20:36',null) ,
(2,13,3,(select price from product where product_id=13)*3,'2019-08-04 11:20:36',null) ,
(7,14,4,(select price from product where product_id=14)*4,'2019-08-05 19:20:36', null) ;

/*
SET FOREIGN_KEY_CHECKS = 0;
TRUNCATE TABLE order_details;
*/

-- insert into order_details

INSERT INTO order_details(cart_id,address,date_ordered,total_price,order_status) VALUES
(2,'Udaipur','2019-08-01 09:20:36',(select sum(price) from cart where cart_id=2 and item_status is null GROUP BY cart_id ),'placed'),
(3,'delhi','2019-08-05 10:20:36',(select sum(price) from cart where cart_id=3 and item_status is null GROUP BY cart_id),'placed') ,
(5,'bikaner','2019-08-06 08:20:36',(select sum(price) from cart  where cart_id=5 and item_status is null GROUP BY cart_id),'placed'),
(6,'jaipur','2019-07-06 11:20:36',(select sum(price) from cart  where cart_id=6 and item_status is null GROUP BY cart_id),'placed'),
(7,'udaipur','2019-08-06 12:20:36',(select sum(price) from cart  where cart_id=7 and item_status is null GROUP BY cart_id),'placed');

-- update status of cart

UPDATE cart SET item_status='delivered' WHERE cart_id=2 AND product_id=2 ;
UPDATE cart SET item_status='shipped' WHERE cart_id=2 AND product_id=3 ;
UPDATE cart SET item_status='placed' WHERE cart_id=3 AND product_id=5 ; 
UPDATE cart SET item_status='shipped' WHERE cart_id=3 AND product_id=1 ;
UPDATE cart SET item_status='returned' WHERE cart_id=3 AND product_id=4 ;
UPDATE cart SET item_status='delivered' WHERE cart_id=5 AND product_id=10 ;
UPDATE cart SET item_status='delivered' WHERE cart_id=5 AND product_id=12 ;
UPDATE cart SET item_status='placed' WHERE cart_id=6 AND product_id=1 ;
UPDATE cart SET item_status='delivered' WHERE cart_id=2 AND product_id=13 ;
UPDATE cart SET item_status='cancelled' WHERE cart_id=7 AND product_id=14 ;

/*
2.b Display Id, Title, Category Title, Price of the products which are Active and 
	recently added products should be at top. 
*/
SELECT product_id, product_name, price ,category_name FROM product 
INNER JOIN  category on
product.category_id=category.category_id
ORDER BY date_added DESC; 


-- 2.c Display the list of products which don't have any images.

SELECT product_id ,product_name FROM product WHERE product_id NOT IN 
(SELECT product_id FROM images);


/*
2.d Display all Id, Title and Parent Category Title for all the Categories listed, sorted by 
	Parent Category Title and then Category Title.
*/
SELECT category_id ,category_name ,ifnull(parent_category,'TOP CATEGORY') AS parent
FROM category ORDER BY parent_category,category_name;


-- 2.e Display Id, Title, Parent Category Title of all the leaf Categories

SELECT category_id ,category_name ,parent_category FROM category WHERE category_id NOT IN
(SELECT parent_id FROM category WHERE parent_id IS NOT NULL);


-- 2.f Display Product Title, Price & Description which falls into particular category Title (i.e. “Mobile”)

SELECT product_id , product_name  ,price FROM product
WHERE category_id=3;


-- 2.g Display the list of Products whose Quantity on hand (Inventory) is under 50.

SELECT product_id,product_name FROM  product WHERE stock < 50 ;