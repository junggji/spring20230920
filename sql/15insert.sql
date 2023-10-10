-- INSERT INTO tableName (columnName1,columnName2, ...)
-- VALUES (value1, value2)

--  column갯수와 value갯수 일치해야한다.
INSERT INTO employees(EmployeeID, LastName, FirstName, BirthDate, Photo, Notes)
VALUE (10, '손', '흥민', '2000-01-01', '사진10', 'epl 득점왕');


INSERT INTO employees(EmployeeID, LastName, FirstName, BirthDate, Photo, Notes)
VALUE (11, '이', '강인', '2000-02-02', '사진11', '드리블 잘함');

-- 모든 column에 값 넣을 떄 컬럼명 나열 생략 가능
INSERT INTO employees
VALUE (12, '김', '민재', '2000-03-03','사진11', '수비 잘함');

-- 특정 컬럼에만 값을 넣을 땐 컬럼명 나열 생략하면 안됨
INSERT INTO employees (EMPLOYEEID, LASTNAME, FIRSTNAME)
VALUE (13, '박', '지성'); -- 나열된 컬럼명과 값의 순서, 갯수가 같아야함

INSERT INTO employees(employeeid, firstname, lastname)
VALUE (14, '차', '범근');

INSERT INTO employees (EmployeeID)
VALUE (15); -- 권장

-- 값의 타입에 따라 넣는 방법이 다름
INSERT INTO employees (EmployeeID)
VALUE ('16'); -- 되긴 됨..

INSERT INTO employees (LastName)
VALUE ('son');

INSERT INTO employees (LastName)
VALUE ('10000'); -- 따옴표 사용 권장

INSERT INTO employees (LastName)
VALUE (10000); -- 되긴 됨..

INSERT INTO employees (BirthDate)
VALUE ('2000-01-01');


SELECT * FROM employees ORDER
    BY EmployeeID DESC;

SELECT * FROM products;

INSERT INTO products (Price)
VALUE (20.10);

INSERT INTO products (Price)
VALUE ('30.33'); -- 되긴 됨...
#
# INSERT INTO products (Price)
# VALUE ('thirteen'); -- d안됨

SELECT * FROM products ORDER BY ProductID DESC;
-- 예) 80번 상품 입력 (모든column)
INSERT INTO products (ProductID, ProductName, SupplierID, CategoryID, Unit, Price)
VALUE (80, 'pasta', 5, 2, '400 ml', '24.10');

-- 예) 새 상품 입력 (productid 빼고)
INSERT INTO products (ProductName, SupplierID, CategoryID, Unit, Price)
VALUE ('pizza', 3, 2, '500kg', 07.00);

SELECT * FROM suppliers ORDER BY SupplierID DESC ;
SELECT * FROM employees ORDER BY EmployeeID DESC ;