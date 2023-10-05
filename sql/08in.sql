-- IN : 하나라도 같으면

SELECT * FROM customers
WHERE Country = 'UK' OR Country = 'spain' OR Country = 'italy';
SELECT * FROM customers
WHERE Country IN ('uk', 'spain', 'taly');

-- 예) 카테고리3, 4에 속한 상품들
SELECT * FROM categories
WHERE CategoryID IN (3, 4);
-- 예) 1996년 7월 4일과 5일에 주문한 주문들
SELECT * FROM orders
WHERE OrderDate IN ('1996-07-04', '1996-07-05');
-- 예) london이나 madrdid, sevilla 에 있는 고객들
SELECT * FROM customers
WHERE City IN ('london', 'madrid', 'sevilla');