use store_front ;

#Q2.1 Display the list of products (Id, Title, Count of Categories) which fall in more than one Categories

SELECT product_name ,COUNT(product.category_id) AS count FROM product
INNER JOIN category ON product.category_id = category.category_id 
GROUP BY product.product_name 
HAVING COUNT(product.category_id) > 1 ;

#Q2.2 Display Count of products as per given price range

SELECT pr.price_range,COUNT(*) AS product_count
FROM(SELECT CASE
               WHEN price>0 AND price<=50 then '0-50'
               WHEN price>50 AND price<=100 then '0-100'
               WHEN price>100 AND price<=500 then '101-500'
               ELSE 'Above 500'
           END AS price_range
    FROM product) pr
GROUP BY pr.price_range;

#Q2.3 Display the Categories along with number of products under each category

SELECT category.category_id , category.category_name ,COUNT(product.category_id) AS count 
FROM category INNER JOIN product ON category.category_id = product.category_id
GROUP BY product.category_id ;
 