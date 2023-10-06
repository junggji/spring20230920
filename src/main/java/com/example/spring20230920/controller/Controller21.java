package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
@RequestMapping("main21")
public class Controller21 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() throws SQLException {
        String sql = """
                SELECT customerName AS name,
                        country
                FROM customers          
                WHERE CustomerID <= 3
                """;
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        try (connection; statement; resultSet) {
            System.out.println("고객 목록");
            while (resultSet.next()) {
//                String name = resultSet.getString(1);
//                String country = resultSet.getString(2);

                //  SELECT절에 있는 column명 그대로 쓰면된다
                String name = resultSet.getString("name");
                String country = resultSet.getString("country");

                System.out.println(name + " : " + country);
            }
        }
    }

    @GetMapping("sub2")
    public void method2() throws SQLException {
        String sql = """
                SELECT CONCAT(lastName, ', ', firstName) AS fullName,
                        BirthDate AS birth,
                        Notes AS `DESC`
                FROM employees
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                String fullName = resultSet.getString("fullName");
                String birth = resultSet.getString("birth");
                String desc = resultSet.getString("DESC");

                System.out.println(fullName +" "+ birth+" " + desc);

            }
        }

    }

}
