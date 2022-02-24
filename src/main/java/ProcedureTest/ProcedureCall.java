package ProcedureTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class ProcedureCall {
    public static void main(String[] args){
        try{
            // 데이터베이스 드라이버를 로드
            Class.forName("org.mariadb.jdbc.Driver");
            // Connection 객체 생성
            Connection con = DriverManager.getConnection(
                    "jdbc:mariadb://127.0.0.1:3306/procedure_test","root","ecross");
            // 프로시저를 실행할 수 있는 Statement 객체 생성
            String sql = "call prc(?,?)";
            String p1 = "hey";
            String p2 = "bbb";
            CallableStatement cstmt = con.prepareCall(sql);
            // ?에 값 바인딩
            //CallableStatement는 SQL의 스토어드프로시저(Stored Procedure)를 실행시키기 위해 사용되는 인터페이스
            cstmt.setString(1, p1);
//            cstmt.registerOutParameter(1, Types.VARCHAR);

            cstmt.setString(2, p2);
//            cstmt.registerOutParameter(2, Types.VARCHAR);
            // 프로시저 실행
            cstmt.executeQuery();

            // 사용다한 객체 닫기
            cstmt.close();
            con.close();

        }
        catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

    }
}
