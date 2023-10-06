package com.example.spring20230920.controller;

import com.example.spring20230920.domain.MyDto16;
import com.example.spring20230920.domain.Mydto15;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.sql.DataSource;
import javax.swing.*;
import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("main20")
public class Controller20 {

    @Autowired
    private DataSource dataSource;

    @GetMapping("sub1")
    public void method1() {

    }

    @GetMapping("sub2")
    public String method2(String id, Model model) throws SQLException {
        // 쿼리 작성 (method6 참고)
        String sql = """
                SELECT CustomerID, CustomerName, Address, Country
                FROM customers
                WHERE CustomerID = ?
                """;

        System.out.println("sql = " + sql);

        // 쿼리 실행
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        List<Mydto15> list = new ArrayList<>();

        try (connection; statement; resultSet) {

            // 실행 결과 처리 (method6 참고, MyDto15 사용)
            while (resultSet.next()) {
                Mydto15 dto = new Mydto15();
                dto.setId(resultSet.getInt(1));
                dto.setName(resultSet.getString(2));
                dto.setAddress(resultSet.getString(3));
                dto.setCountry(resultSet.getString(4));

                list.add(dto);
            }
        }
        // 처리한 결과 model에 attribute로 넣고
        model.addAttribute("customerList", list);

        return "/main19/sub6";
    }

    @GetMapping("sub3")
    public void method3(String id) throws Exception {
        String sql = """
                SELECT customerID, customerName, country
                FROM customers
                WHERE customerId = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        // ?를 채우는 메소드 statement. set~~~
        // ? 여러가지 가능, n번째 위치에 ~값
        statement.setString(1, id);
        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet) {

            while (resultSet.next()) {
                System.out.println("고객 정보");
                System.out.println("id = " + resultSet.getString(1));
                System.out.println("name = " + resultSet.getString(2));
            }
        }
    }

    // /main20/sub4?pid=5
    @GetMapping("sub4")
    public void method4(Integer pid) throws Exception {
        String sql = """
                SELECT productId, productName
                FROM products
                WHERE productId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, pid);
        ResultSet resultSet = statement.executeQuery();


        while (resultSet.next()) {
            System.out.println();
            System.out.println("상품 정보");
            System.out.println("상품 번호 : " + resultSet.getInt(1));
            System.out.println("상품명 = " + resultSet.getString(2));
        }
    }

    // /main20/sub5?country=spain
    // 콘솔에 spain에 사는 고객 이름 출력
    @GetMapping("sub5")
    public void method5(String country) throws SQLException {
        String sql = """
                SELECT CustomerName,City
                FROM customers
                WHERE Country = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, country);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            System.out.println();
            System.out.println("고객 정보");
            System.out.println("고객 이름 : " + resultSet.getString(1));
            System.out.println("거주 도시 : " + resultSet.getString(2));
        }

    }

    @GetMapping("sub6")
    public void method6(String c1, String c2) throws Exception {
        String sql = """
                SELECT customerName, country
                FROM customers
                WHERE country = ? OR country = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, c1);
        statement.setString(2, c2);
        ResultSet resultSet = statement.executeQuery();

        System.out.println();
        System.out.println("고객 목록");
        while (resultSet.next()) {
            String country = resultSet.getString(2);
            String name = resultSet.getString(1);
            System.out.println(country);
            System.out.println(name);
        }
    }

    @GetMapping("sub7")
    public void method7() {

    }

    @GetMapping("sub8")
    public String method8(Model model, Double min, Double max) throws SQLException {
        String sql = """
                SELECT ProductID, Unit, ProductName, Price
                FROM products
                WHERE Price >= ? AND Price <= ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setDouble(1, min);
        statement.setDouble(2, max);
        ResultSet resultSet = statement.executeQuery();
        List<MyDto16> list = new ArrayList<>();

        try (connection; statement; resultSet) {

            while (resultSet.next()) {
                MyDto16 dto = new MyDto16();
                dto.setPid(resultSet.getInt(1));
                dto.setUnit(resultSet.getString(2));
                dto.setProductName(resultSet.getString(3));
                dto.setPrice(resultSet.getDouble(4));

                list.add(dto);
            }
            model.addAttribute("productList", list);
        }
        return "/main19/sub5";

    }

    // /main20/sub9?country=spain&country=mexico&country=uk
    @GetMapping("sub9")
    public void method9(@RequestParam("country") List<String> countryList) throws SQLException {
        String questionMarks = "";
        for (int i = 0; i < countryList.size(); i++) {
            questionMarks += "?";

            if (i < countryList.size() - 1) {
                questionMarks += ", ";
            }
        }
        // 특정 국가에 속한 고객들 조회
        String sql = """
                SELECT *
                FROM customers
                WHERE country IN ("""

                +

                questionMarks

                +

                """
                        )
                        """;

//        System.out.println("sql = " + sql);

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        for (int i = 0; i < countryList.size(); i++) {
            statement.setString(i + 1, countryList.get(i));
        }
        ResultSet resultSet = statement.executeQuery();

        try (connection; statement; resultSet) {
            System.out.println("고객 목록");
            while (resultSet.next()) {
                String name = resultSet.getString(2);
                String country = resultSet.getString(7);

                System.out.println(name + " : " + country);
            }
        }
    }

    @GetMapping("sub10")
    public void method10(Model model) throws Exception {
        // 공급자의 국가 목록 조회
        String sql = """
                SELECT DISTINCT country
                FROM suppliers
                """;

        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        List<String> list = new ArrayList<>();

        try (connection; statement; resultSet) {
            while (resultSet.next()) {
                list.add(resultSet.getString(1));
            }
        }

        model.addAttribute("countryList", list);

    }

    @GetMapping("sub11")
    // RequestParam "~~" 은 ***넘어오는***jsp(sub10)의 name들과 맞춰줘야한다.
    public String method11(@RequestParam("country") List<String> nlist, Model model) throws Exception {
        // IN을 쓰기 위해서 parameter갯수와 ? 갯수를 맞춰주기
                String questionmarks ="";
         // ?의 갯수는 nlist size와 똑같다
                for(int i = 0; i<nlist.size(); i++) {
                    questionmarks += "?";
         // ,의 갯수는 ? 보다 -1 이니까
                    if (i<nlist.size()-1) {
                        questionmarks += ", ";
                    }
                }

            String sql = """
                    SELECT *
                    FROM suppliers
                    WHERE Country IN ("""
                    +
                    questionmarks
                    +
                    """
                    )
                    """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        // set작성
        for (int i = 0; i<nlist.size(); i++){
            statement.setString(i+1, nlist.get(i));
        }
        ResultSet resultSet = statement.executeQuery();

        List<Map<String, Object>> list1 = new ArrayList<>();
        try(connection; statement; resultSet) {

            while(resultSet.next()) {
                Map<String, Object> map = new HashMap<>();
                map.put("id", resultSet.getString(1));
                map.put("name", resultSet.getString(2));
                map.put("country", resultSet.getString(7));

                list1.add(map);
            }
        }

        model.addAttribute("listlist", list1);

        return "/main20/sub11";
    }


}
