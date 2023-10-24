package com.example.spring20230920.dao;

import com.example.spring20230920.domain.MyDto40;
import com.example.spring20230920.domain.MyDto41;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;

@Mapper
public interface MyDao7 {

    @Select("""
        SELECT * FROM customers
        WHERE CustomerID = #{id}
        """)
    Map<String, Objects> selectByCustomerId(Integer id);


    @Select("""
        SELECT * FROM employees
        WHERE EmployeeID = #{id}
        """)
    Map<String, Objects> selectByEmployeeId(Integer id);

    @Insert("""
        INSERT INTO employees (LastName, FirstName, BirthDate)
        VALUES (#{lastName}, #{firstName}, #{birthDate})
        """)
    int insertEmployee(String lastName, String firstName, LocalDate birthDate);

    @Insert("""
        INSERT INTO products (ProductName, Price, CategoryID)
        VALUES (#{name}, #{price}, #{category})
        """)
    int inserProduct(String name, Double price, Integer category);

    @Delete("""
        DELETE FROM products
        WHERE ProductID = #{pid}
        """)
    int deleteBycrounctId(Integer pid);

    @Delete("""
        DELETE FROM customers
        WHERE CustomerID = #{pid}
        """)
    int deleteByCustomer(Integer pid);

    @Update("""
        UPDATE products
        SET price = #{price},
            categoryID = #{category},
            productName = #{name}
        WHERE productId = #{id}
        """)
    int updateProduct(MyDto40 dto);

    @Update("""
        UPDATE employees
        SET FirstName = #{firstName},
            LastName = #{lastName},
            BirthDate = #{birthDate}
        WHERE EmployeeID = #{id}
        """)
    int updateEmployee(MyDto41 dto);
}
