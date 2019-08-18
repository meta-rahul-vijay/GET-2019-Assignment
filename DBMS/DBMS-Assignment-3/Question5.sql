use store_front ;

#Q5.1 Create a view displaying the order information (Id, Title, Price, Shopper’s name, Email, 
	  #Orderdate, Status) with latest ordered items should be displayed first for last 60 days.
      
CREATE OR REPLACE VIEW past_60_days_orders AS
SELECT order_details.order_id,product.product_id,product.product_name ,product.price AS rate ,cart.quantity ,cart.price ,shopper_name ,
       order_details.date_ordered , item_status FROM order_details , product ,cart , shopper
WHERE order_details.cart_id = cart.cart_id AND
      cart.product_id =product.product_id AND
      cart.cart_id = shopper.shopper_id AND
      order_details.date_ordered > CURRENT_TIMESTAMP - INTERVAL 60 DAY
ORDER BY order_details.date_ordered DESC;

#Q5.2 Use the above view to display the Products(Items) which are in ‘shipped’ state

SELECT product_id , product_name
FROM past_60_days_orders
WHERE item_status = "shipped";

#Q5.3 Use the above view to display the top 5 most selling products

SELECT product_name, SUM(quantity) AS total_bought
FROM past_60_days_orders
GROUP BY product_name
ORDER BY total_bought DESC LIMIT 5;