package com.example.spring20230920.dao;

import com.example.spring20230920.domain.*;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper // mybatis가 붙는 annotation
public interface MyDao4 {

    @Select("""
        SELECT CustomerName
        FROM customers
        WHERE CustomerID = #{customerId}
        """)
    // 파라미터가 하나면 이름이 일치하지 않아도 됨
    // 두 개 이상이면 꼭 이름을 맞춰 줘야한다.
    String select(int customerId); // parameter명을 위의 #{}안에 넣어주면 된다.

    @Select("""
        SELECT ProductName
        From products
        WHERE Price BETWEEN #{from} AND #{to}
        """)
    List<String> select1(Double from, Double to);

    // from~to 에 주문된 상품명 출력 (날짜 기준 정렬해서, 중복없이)
    @Select("""
        SELECT DISTINCT (p.ProductName)
        FROM products p JOIN orderdetails od
            ON od.ProductID = p.ProductID
            JOIN orders o ON o.OrderID = od.OrderID
            WHERE o.OrderDate BETWEEN #{from} AND #{to}
            ORDER BY 1
        """)
    List<String> select2(LocalDate from, LocalDate to);

    @Select("""
        SELECT ProductName
        FROM products
        WHERE Price BETWEEN #{min} AND #{max}
        """)
    List<String> select4(MyDto25 dto);

    // country1과 country2에 사는 고객명들 출력
    @Select("""
        SELECT CustomerName
        FROM customers
        WHERE Country = #{country1} OR Country = #{country2}
        """)
    List<String> select5(MyDto26 dto);

    @Select("""
        SELECT COUNT(OrderID)
        FROM orders
        WHERE OrderDate BETWEEN #{dto1.from} AND #{dto2.to}
        """)
    Integer select6(MyDto27 dto1, MyDto28 dto2);
// javaBean이 2개이상이면 property 명 써준다.

    // /main30/sub7?page=2&rows=10&keyword=a
    /*
        SELECT customerNAME
        FROM customers
        WHERE customerName LIKE '%a%'
        LIMIT 0, 10
        10 10
        20 10
        */
    @Select("""
        SELECT CustomerName
        FROM customers
        WHERE CustomerName LIKE CONCAT('%',#{dto2.keyword},'%')
        LIMIT #{dto1.from}, #{dto1.rows}
        """)

    List<String> select7(MyDto29 dto1, MyDto30 dto2);

    @Insert("""
        INSERT INTO customers (CustomerName, Country)
        VALUE (#{name}, #{country})
        """)
    int insert1(MyDto31 dto); // executeUpdate의 반환값(몇줄에 영향미친지)인 int값 반환

    @Insert("""
        INSERT INTO employees (FirstName, LastName)
        VALUE (#{firstName}, #{lastName})
        """)
    int insert2(MyDto32 emp);

    @Delete("""
        DELETE FROM customers
        WHERE CustomerID = #{id}
        """)
    int delete1(Integer id);

    @Delete("""
        DELETE FROM products
        WHERE ProductID = #{pid}
               """)
    int delete2(Integer pid);

    @Select("""
        SELECT EmployeeID id,
               LastName,
               FirstName,
               BirthDate,
               Photo,
               Notes
        FROM employees
        WHERE EmployeeID = #{id}
        """)
    MyDto33Employee select8(Integer id);

    @Update("""
        UPDATE employees
        SET LastName = #{lastName},
            FirstName = #{firstName},
            Photo = #{photo},
            Notes = #{notes},
            BirthDate = #{birthDate}
        WHERE EmployeeID = #{id}
        """)
    int update1(MyDto33Employee employee);

    @Select("""
        SELECT CustomerID id,
                CustomerName CNAME,
                ContactName,
                Address,
                City,
                PostalCode,
                Country
        FROM customers
        WHERE CustomerID = #{id}
                """)
    MyDto34customer select9(Integer id);

    @Update("""
        UPDATE customers
        SET CustomerName = #{CNAME},
            ContactName = #{contactName},
            Address = #{address},
            City = #{city},
            PostalCode = #{postalCode},
            Country = #{country}
        WHERE CustomerID = #{id}
        """)
    int update2(MyDto34customer customer);
}
