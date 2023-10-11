SELECT * FROM products;
SELECT * FROM products WHERE ProductID = 2;
UPDATE products
SET ProductName = '차이즈',
    Unit = '10박스',
    Price = 36.00
WHERE ProductID = 2; -- WHERE 절 꼭 쓸것!

-- 예) 1번 고객의 이름 수정하기
SELECT * FROM customers WHERE CustomerID = 1;
UPDATE customers
SET CustomerName = 'James'
WHERE CustomerID = 1;
-- 예) 5번 직원의 notes 변경하기
SELECT * FROM employees WHERE EmployeeID = 5;
UPDATE employees
SET Notes = 'hungry'
WHERE EmployeeID = 5;
-- 예) 1번 공급자의 전화번호, 주소 변경하기
SELECT * FROM suppliers WHERE SupplierID = 1;
UPDATE suppliers
SET Phone = '010-1234-8888',
    Address = 'Ansan'
WHERE SupplierID = 1;

--
SELECT * FROM products
         WHERE CategoryID = 1;

UPDATE products
SET Price = Price * 2
WHERE CategoryID = 1;

SELECT * FROM shippers;