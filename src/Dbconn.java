import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dbconn {
    protected Connection dbConn = null;
    private String driverName="com.mysql.cj.jdbc.Driver";
    private String dbURL="jdbc:mysql://db4free.net:3306/homelocal?serverTimezone=UTC";
    private String userName="mysqltest001";
    private String userPwd="87654321";

    public void dbConn(){

        try{
            Class.forName(driverName);
            dbConn= DriverManager.getConnection(dbURL, userName,userPwd);
            System.out.println("Connection successful");
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public void closeConn() throws SQLException {
        //	statement.close();
        //	dbConn.close();

    }
    private Connection getConnection(){

        try{
            Class.forName(driverName);
            dbConn=DriverManager.getConnection(dbURL, userName,userPwd);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return dbConn;
    }
    public static void main(String[] args){
        Dbconn d=new Dbconn();
        System.out.println(d.getConnection());
    }
}
