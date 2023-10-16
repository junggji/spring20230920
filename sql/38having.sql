-- HAVING : 그룹함수 연산결과(SUM같은 것)를 조건으로 줄 수 있는 키워드

USE w3schools;

-- 10만 달러 이상 소비한 고객 조회
SELECT * FROM
    (SELECT  c.CustomerName, SUM(od.Quantity * p.Price) 주문금액
     FROM employees e
              JOIN orders o
                   ON e.EmployeeID = o.EmployeeID
              JOIN orderdetails od
                   ON o.OrderID = od.OrderID
              JOIN products p
                   ON p.ProductID = od.ProductID
              JOIN customers c
                   ON c.CustomerID = o.CustomerID
     GROUP BY c.CustomerID
     ORDER BY 2 DESC) t1
WHERE t1.주문금액 >= 100000;

-- HAVING
SELECT  c.CustomerName, SUM(od.Quantity * p.Price) 주문금액
FROM employees e
         JOIN orders o
              ON e.EmployeeID = o.EmployeeID
         JOIN orderdetails od
              ON o.OrderID = od.OrderID
         JOIN products p
              ON p.ProductID = od.ProductID
         JOIN customers c
              ON c.CustomerID = o.CustomerID
GROUP BY c.CustomerID
HAVING 주문금액 >= 100000 -- 중간에 WHERE절로는 결과값으로 필터링 불가하므로, 연산이 끝난 후 HAVING으로 필터링 가능
ORDER BY 주문금액 DESC;

-- 예) 총 처리 금액 10만 달러 미만인 직원 조회
-- orders, orderDetails, products, employees
SELECT LastName, FirstName, SUM(p.Price * od.Quantity) 처리금액
FROM employees e
    JOIN orders o
        ON e.EmployeeID = o.EmployeeID
    JOIN orderdetails od
        ON od.OrderID = o.OrderID
    JOIN products p
        ON p.ProductID = od.ProductID
GROUP BY e.EmployeeID
HAVING SUM(p.Price * od.Quantity) < 100000;
-- HAVING 처리금액 < 100000; 둘다 가능~