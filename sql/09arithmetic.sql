SELECT Price FROM products WHERE ProductID = 1;
SELECT Price +1 FROM products WHERE ProductID = 1;
SELECT Price -10.5 FROM products WHERE ProductID = 1;
SELECT Price *3 FROM products WHERE ProductID = 1;
SELECT Price /5 FROM products WHERE ProductID = 1;

SELECT ProductName, Price * 2 FROM products;

SELECT ProductName + 1, Price FROM products; -- 문자열 연결연산은 안된다!!
SELECT CONCAT(ProductName, 1), Price FROM products; -- 문자열 연결연산은 concat 사용(Maria DB에서 가능한 내장함수)

SELECT LastName, BirthDate FROM employees WHERE EmployeeID = 1; -- 1968-12-08
SELECT LastName, BirthDate +1 FROM employees WHERE EmployeeID = 1; -- 19681209 (숫자로 자동변환)
SELECT LastName, ADDDATE(BirthDate, INTERVAL 1 DAY)                 -- 1968-12-09 (날짜변경 함수 사용 ADDDATE)
FROM employees
WHERE EmployeeID = 1;

SELECT * FROM employees;
SELECT EmployeeID, LastName, FirstName FROM employees;
SELECT EmployeeID, CONCAT(LastName, FirstName) FROM employees;
SELECT EmployeeID, CONCAT(LastName, ' ', FirstName) FROM employees; -- 띄어쓰기
SELECT EmployeeID, CONCAT(FirstName, ' ', lastName) FROM employees;
SELECT EmployeeID,
       CONCAT(FirstName, ' ', lastName),
       ADDDATE(BirthDate, INTERVAL -1 YEAR )
FROM employees;

-- 예) 주문수량(quantity) *2 결과 조회 (orderDetails 테이블)
SELECT Quantity * 2 FROM orderdetails;
-- 예) "city, country" 형식으로 고객테이블 조회
SELECT CONCAT('"', City, ' ', Country, '"') FROM customers;



