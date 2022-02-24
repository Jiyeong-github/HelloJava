package ProcedureTest;

import java.sql.*;

public class MariaDBConnector {
    public static void main(String[] args) {
        Connection con = null;

        String server = "jdbc:mariadb://127.0.0.1:3306";
        String database = "procedure_test";
        String user_name = "root";
        String password = "ecross";

        //드라이버 로딩
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(" 드라이버 로딩 오류 : " + e.getMessage());
            e.printStackTrace();
        }
        //드라이버 연결
        try {
            con = DriverManager.getConnection(
                    server + "/" +
                    database +
                    "?useSSL=false", user_name, password); // SSL 실행 확인
            System.out.println("연결 성공");
        } catch(SQLException e) {
            System.err.println("에러 내용 :" + e.getMessage());
            e.printStackTrace();
        }

        try {
            if(con != null)
                con.close();
        } catch (SQLException e) {}
    }
}