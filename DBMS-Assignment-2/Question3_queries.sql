use store_front ;

-- 3.a Display Recent 50 Orders placed (Id, Order Date, Order Total).

SELECT order_id ,date_ordered ,total_price FROM order_details
ORDER BY date_ordered DESC
LIMIT 50 ;


-- 3.b Display 10 most expensive Orders.

SELECT order_id ,total_price FROM  order_details
ORDER BY total_price DESC
LIMIT 10 ;


/*
3.c Display all the Orders which are placed more than 10 days old and
    one or more items from those orders are still not shipped.
*/
SELECT order_id ,date_ordered ,total_price FROM order_details
INNER JOIN cart ON cart.cart_id = order_details.cart_id
WHERE date_ordered < CURRENT_TIMESTAMP - INTERVAL 10 DAY AND cart.item_status = 'placed';


-- 3.d Display list of shoppers which haven't ordered anything since last month.

SELECT shopper_id ,shopper_name FROM shopper
WHERE shopper_id NOT IN
(SELECT cart_id FROM order_details WHERE date_ordered > CURRENT_TIMESTAMP - INTERVAL 30 DAY);


-- 3.e Display list of shopper along with orders placed by them in last 15 days

SELECT shopper_id ,shopper_name ,order_id ,date_ordered ,total_price FROM order_details
INNER JOIN shopper ON shopper.shopper_id = order_details.cart_id
WHERE date_ordered >= CURRENT_TIMESTAMP - INTERVAL 15 DAY ;


-- 3.f Display list of order items which are in “shipped” state for particular Order Id (i.e.: 1020)) 

SELECT product_id , quantity ,price ,date_added ,item_status FROM cart
INNER JOIN order_details ON cart.cart_id = order_details.cart_id
WHERE item_status='shipped' AND order_id=2;


-- Q3.g Display list of order items along with order placed date which fall between Rs 20 to Rs 50 price.

SELECT product_id , quantity ,price ,date_added ,item_status FROM cart
INNER JOIN order_details ON cart.cart_id = order_details.cart_id
WHERE price BETWEEN 2000 AND 5000 ;