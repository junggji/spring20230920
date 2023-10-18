package com.example.spring20230920.dao;

import com.example.spring20230920.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Mapper
public interface MyDao3 {

    // 1행 1열
    @Select("""
        SELECT CustomerName FROM customers
        WHERE customerID = 1
""")
    String select1(); // 열에 해당하는 java의 타입을 반환타입으로 사용

    @Select("""
        SELECT Price FROM products
        WHERE ProductID = 1
""")
    Double select2();  // String타입을 써도 괜찮다

    @Select("""
        SELECT LastName FROM employees
        WHERE EmployeeID = 1
    """)
    String select3();

    @Select("""
        SELECT BirthDate FROM employees
        WHERE EmployeeID = 2
    """)
    String select4();


    // --------------하나의 열 여러행 (반환타입 List로 담는다) ----------------
    @Select("""
        SELECT DISTINCT Country FROM customers
        ORDER BY 1
        """)
    List<String> select5();

    @Select("""
        SELECT BirthDate FROM employees
        """)
    List<LocalDate> select6();

    @Select("""
        SELECT Price FROM products
        """)
    List<Double> select7();

    @Select("""
        SELECT CustomerID, CustomerName, Address
        FROM customers
        WHERE CustomerID = 1
        """)
    Map<String, Object> select8(); // key에는 column명, value에는 column해당하는 값

    @Select("""
        SELECT p.ProductName, p.Price, c.CategoryName FROM products p
        JOIN categories c ON c.CategoryID = p.CategoryID
        WHERE p.ProductID = 1
        """)
    Map<String, Object> select9();

    @Select("""
        SELECT EmployeeID,LastName, FirstName FROM employees
        WHERE EmployeeID = 1
        """)
    MyDto19 select10();
    // javaBean쓸때 컬럼명으로 쓰고, 대소문자구분 X

    @Select("""
        SELECT ProductName name, Price, CategoryName cate
        FROM products p JOIN categories c ON p.CategoryID = c.CategoryID
        WHERE ProductID = 1
        """)
    MyDto20 select11();
    // javaBean property명에 맞추려면 쿼리에서 별칭을 맞게 주면 된다

    @Select("""
        SELECT CustomerID id, CustomerName name, Country country
        FROM customers
        WHERE CustomerID = 2
        """)
    MyDto21 select12();

    @Select("""
        SELECT ProductID id, ProductName name, Price
        FROM products
        WHERE CategoryID = 2
        ORDER BY Price
        """)
    List<Map<String, Object>> select13();

    // 1996년 7월 4일에 주문된 상품명, 상품의 수량, 상품의 가격
    @Select("""
        SELECT ProductName name, Quantity, Price
        FROM products p
            JOIN orderdetails od
                ON p.ProductID = od.ProductID
            JOIN orders o
                ON od.OrderID = o.OrderID
        WHERE o.OrderDate = '1996-07-04'
        """)
    List<Map<String, Object>> select14();

    @Select("""
        SELECT ProductName name, Quantity, Price
        FROM products p
            JOIN orderdetails od
                ON p.ProductID = od.ProductID
            JOIN orders o
                ON od.OrderID = o.OrderID
        WHERE o.OrderDate = '1996-07-04'
        """)
    List<MyDto22> select15();

    // 1번 카테고리 상품들이 주문된 날짜, 상품명, 카테고리명, 수량, 가격
    // 날짜, 상품명 순으로 정렬 orderdetails, order, products, category
    @Select("""
        SELECT o.OrderDate, p.ProductName, c.CategoryName, od.Quantity, p.Price
        FROM orders o JOIN orderdetails od ON o.OrderID = od.OrderID
                    JOIN products p ON p.ProductID = od.ProductID
                    JOIN categories c ON c.CategoryID = p.CategoryID
            WHERE c.CategoryID = 1
            ORDER BY o.OrderDate, p.ProductName
        """)
    List<Map<String, Object>> select16();

    @Select("""
            SELECT CustomerName
            FROM customers
            WHERE CustomerID = 100
        """)
    String select17();

    @Select("""
        SELECT CustomerID
        FROM customers
        WHERE CustomerID = 100
        """)
    Integer select18();

    @Select("""
        SELECT CustomerID id,
            CustomerName name,
            Country
        FROM customers
        WHERE CustomerID = 1
        """)
    MyDto24 select19();

    @Select("""
        SELECT CustomerID id,
            CustomerName name,
            Country
        FROM customers
        WHERE CustomerID > 1
        """)
    MyDto24 select20();
}
