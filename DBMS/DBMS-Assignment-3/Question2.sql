use store_front ;

#Q2.1 Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories

SELECT product_name ,COUNT(product.category_id) AS count FROM product
INNER JOIN category ON product.category_id = category.category_id 
GROUP BY product.product_name 
HAVING COUNT(product.category_id) > 1 ;

#Q2.2 Display Count of products as per given price range

# i. 0 - 100
SELECT COUNT(*) AS count FROM product WHERE price BETWEEN 0 AND 100 ;

# ii. 100 - 500
SELECT COUNT(*) AS count FROM product WHERE price BETWEEN 100 AND 500 ;

# iii. above 500
SELECT COUNT(*) AS count FROM product WHERE price > 500 ;

#Q2.3 Display the Categories along with number of products under each category

SELECT category.category_id , category.category_name ,COUNT(product.category_id) AS count 
FROM category INNER JOIN product ON category.category_id = product.category_id
GROUP BY product.category_id ;
 