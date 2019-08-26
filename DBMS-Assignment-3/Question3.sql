use store_front ;

#Q3.1 Display Shopper’s information along with number of orders he/she placed during last 30 days.

SELECT order_details.cart_id , shopper.shopper_name ,COUNT(order_details.cart_id) AS count
FROM order_details INNER JOIN shopper ON shopper.shopper_id = order_details.cart_id 
WHERE order_details.date_ordered >= CURRENT_TIMESTAMP - INTERVAL 30 DAY 
GROUP BY order_details.cart_id;

#Q3.2 Display the top 10 Shoppers who generated maximum number of revenue in last 30 days

SELECT order_details.cart_id , shopper.shopper_name ,SUM(total_price) AS revenue
FROM order_details INNER JOIN shopper ON shopper.shopper_id = order_details.cart_id 
WHERE order_details.date_ordered >= CURRENT_TIMESTAMP - INTERVAL 30 DAY 
GROUP BY order_details.cart_id
ORDER BY revenue DESC
LIMIT 10;

#Q3.3 Display top 20 Products which are ordered most in last 60 days along with numbers.

SELECT cart.product_id , product.product_name ,COUNT(cart.product_id) AS top_product
FROM cart INNER JOIN product ON cart.product_id = product.product_id
WHERE cart.date_added >= CURRENT_TIMESTAMP - INTERVAL 60 DAY 
GROUP BY cart.product_id
ORDER BY top_product DESC
LIMIT 20;

#Q3.4 Display Monthly sales revenue of the StoreFront for last 6 months. It should display each month’s sale.

SELECT MONTHNAME(order_details.date_ordered) AS month , SUM(order_details.total_price) AS total_revenue
FROM order_details
WHERE order_details.date_ordered > CURRENT_TIMESTAMP - INTERVAL 6 month 
GROUP BY month(order_details.date_ordered);

#Q3.5 Mark the products as Inactive which are not ordered in last 90 days.

UPDATE product SET isactive=false 
WHERE product.product_id NOT IN 
(SELECT cart.product_id FROM cart INNER JOIN order_details ON cart.cart_id=order_details.cart_id 
 WHERE order_details.date_ordered > CURRENT_TIMESTAMP - INTERVAL 90 DAY);
 
#Q3.6 Given a category search keyword, display all the Products present in this category/categories. 

SELECT product.product_id ,product_name FROM product
INNER  JOIN category ON product.category_id = category.category_id
WHERE category_name = 'mobile' ;
 
#Q3.7 Display top 10 Items which were cancelled most.

SELECT cart.product_id , product_name FROM cart
INNER JOIN product ON product.product_id =cart.product_id
WHERE  item_status = 'cancelled'
GROUP BY cart.product_id 
ORDER BY count(cart.product_id ) DESC;

