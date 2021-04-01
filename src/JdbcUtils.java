import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class JdbcUtils {
    private static final String USERNAME = "mysqltest001";
    private static final String PASSWORD = "87654321";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://db4free.net:3306/homelocal?serverTimezone=UTC";
    private static Connection connection;
    private static PreparedStatement pstmt;
    private ResultSet resultSet;
    public JdbcUtils() {
        // TODO Auto-generated constructor stub
        try{
            Class.forName(DRIVER);
            System.out.println("数据库连接成功！");
        }catch(Exception e){

        }
    }

    public Connection getConnection(){
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public static void main(String[] args) {
        JdbcUtils jdbcUtils = new JdbcUtils();
        jdbcUtils.getConnection();


//        String name = "张三";
//        int age = 23;
//        jdbcUtils.update(name,age);

//        String name = "王明";
//        jdbcUtils.del(name);
//        jdbcUtils.add();

        jdbcUtils.select();



        /*******************增*/

    }
    public void add() {
        String sql = "insert into student (id,name, age) values (?,?, ?)";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 2);
            pstmt.setString(2, "王明");
            pstmt.setInt(3, 20);
//            pstmt.setString(2,"小明");
//            pstmt.setString(3,"21");
//            pstmt.setString(4,"李四");
//            pstmt.setString(5,"25");
            pstmt.executeUpdate();
            System.out.println("增加成功！");
            pstmt.close();
//            boolean flag = jdbcUtils.updateByPreparedStatement(sql, params);
//            System.out.println(flag);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void select() {
        String sql = "select * from  student";
        try {
            pstmt = connection.prepareStatement(sql);
            resultSet = pstmt.executeQuery(sql);
            while (resultSet.next()) {
                String name = resultSet.getNString("name");
                int id = resultSet.getInt("id");
                int age = resultSet.getInt("age");
                System.out.println(id + name + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(String name,int age){
        String sql = "update student set age=? where name=?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,age);
            pstmt.setString(2,name);
            pstmt.executeUpdate();
            System.out.println("成功");
            pstmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void del(String name){
        String sql = "delete from student where name = ? ";
        try{
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.executeUpdate();
            pstmt.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
