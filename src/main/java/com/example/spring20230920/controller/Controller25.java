package com.example.spring20230920.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("main25")
public class Controller25 {

    @Autowired
    private DataSource dataSource;

    // parameter받아서 데이터 delete
    @GetMapping("sub1")
    private void method1(@RequestParam(value = "id", required = false) Integer customerID) throws SQLException {
        if (customerID == null) {
            System.out.println("삭제할 id를 넣어주세요");
            return;
        }
        String sql = """
                DELETE FROM customers
                WHERE customerID = ?
                """;
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, customerID);

        try (connection; statement) {

            int rows = statement.executeUpdate(); // insert, delete, update (int타입 리터한다 (몇개의 행에 영향을 미쳤는가?)

            if (rows == 1) {
                System.out.println(rows + "개 잘 지워짐");
            } else {
                System.out.println("지워지지 않음");
            }

        }
    }

    @GetMapping("sub2")
    public void method2() {

    }

    @PostMapping("sub2")
    public void method3(@RequestParam(value = "pid") Integer productID) throws SQLException {
        String sql = """
                DELETE FROM products
                WHERE ProductID = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, productID);

        try (connection; statement) {
            int i = statement.executeUpdate();

            if (i == 1) {
                System.out.println("id :" + productID + "잘 지워짐");
            } else {
                System.out.println("지우지 못함");
            }

        }
    }

    @GetMapping("sub4")
    public void method4() throws SQLException {
        String sql = """
                UPDATE shippers
                SET
                    shipperName = ?,
                    phone = ?
                WHERE
                    shipperId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {

            statement.setString(1, "이강인");
            statement.setString(2, "01044442222");
            statement.setInt(3, 1);

            int rows = statement.executeUpdate();

            if (rows == 1) {
                System.out.println("잘 변경됨");
            } else {
                System.out.println("안됨");
            }
        }

    }

    @GetMapping("sub5")
    public void method5(@RequestParam("id") Integer shipperId, Model model) throws SQLException {
        String sql = """
                SELECT * FROM shippers
                WHERE shipperId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setInt(1, shipperId);

            ResultSet resultSet = statement.executeQuery();

            try (resultSet) {
                if (resultSet.next()) {
                    model.addAttribute("shipper", Map.of("shipperId", resultSet.getInt("shipperId"),
                            "shipperName", resultSet.getString("shipperName"),
                            "phone", resultSet.getString("phone")));
                }

            }

        }

    }

    @PostMapping("sub5")
    public String method6(@RequestParam("id") Integer shipperId,
                        @RequestParam("name") String shipperName,
                        @RequestParam("phone") String phone,
                          RedirectAttributes rttr) throws SQLException {
        String sql = """
                UPDATE shippers
                SET shipperName = ?,
                    phone = ?
                WHERE ShipperID = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);
        try (connection; statement) {
            statement.setString(1, shipperName);
            statement.setString(2, phone);
            statement.setInt(3, shipperId);

            int rows = statement.executeUpdate();

            if (rows == 1) {
                System.out.println("잘 변경");
            } else {
                System.out.println("못 변경");
            }
        }
        rttr.addAttribute("id", shipperId); // 페이지 redirect할때 id=shipperId 값처럼 파라미터 준채로 넘어감
        return "redirect:/main25/sub5";
    }

    @GetMapping("sub7")
    public void method7(@RequestParam(value = "id", required = false) Integer employeeId, Model model) throws SQLException {
        if (employeeId == null) {
            return;
        }
        String sql = """
                SELECT * FROM employees
                WHERE employeeId = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement) {
            statement.setInt(1, employeeId);

            ResultSet resultSet = statement.executeQuery();

            try (resultSet) {
                if (resultSet.next()) {
                    String lastName = resultSet.getString("lastName");
                    String firstName = resultSet.getString("firstName");
                    LocalDate birthDate = resultSet.getTimestamp("birthDate").toLocalDateTime().toLocalDate();
                    String photo = resultSet.getString("photo");
                    String notes = resultSet.getString("notes");

                    model.addAttribute("employee", Map.of("lastName", lastName,
                            "firstName", firstName,
                            "birthDate", birthDate,
                            "photo", photo,
                            "notes", notes,
                            "employeeId", employeeId));

                }
            }
        }

    }

    @PostMapping("sub7")
    public String method8(@RequestParam("id") Integer employeeId,
                       @RequestParam("lastName") String lastName,
                       @RequestParam("firstName") String firstName,
                       @RequestParam("birthDate") String birthDate,
                       @RequestParam("photo") String photo,
                       @RequestParam("notes") String notes,
                       RedirectAttributes rttr
                       ) throws SQLException {
        String sql = """
                UPDATE employees
                SET LastName = ?,
                    FirstName = ?,
                    birthDate = ?,
                    photo = ?,
                    notes = ?
                WHERE EmployeeID = ?
                """;

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(sql);

        try (connection; statement){
            statement.setString(1, lastName);
            statement.setString(2,firstName);
            statement.setString(3,birthDate);
            statement.setString(4,photo);
            statement.setString(5,notes);
            statement.setInt(6,employeeId);

            int rows = statement.executeUpdate();

            if (rows == 1) {
                System.out.println("완료");
            } else {
                System.out.println("오류");
            }

        }
        rttr.addAttribute("id", employeeId);
        return "redirect:/main25/sub7";
    }

    @GetMapping("sub9")
    public String method9() {
        // Controller의 request handler 메소드의 리턴이
        // void(또는 null 리턴) 이면 view의 이름으로 해석

        // String 이면 view의 이름으로 해석
        // "redirect:" 접두어가 붙으면
        // 응답코드가 302이고 location 응답헤더의 값이 접두어 이후의 값으로 셋팅

        return "redirect:/main25/sub10";
    }

    @GetMapping("sub10")
    public void method10(){
        System.out.println("Controller25.method10");
    }
}
