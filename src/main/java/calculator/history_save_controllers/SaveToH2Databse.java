package calculator.history_save_controllers;

import java.sql.*;

import static calculator.currentState.CurrentOperation.*;
import static calculator.history_save_controllers.EMysqlProperties.*;

public class SaveToH2Databse {

    public static void saveCurrentStateToH2Database(){
        Connection conn = null;
        Statement stmt = null;
try {
    conn = DriverManager.getConnection(DB_CONNECTION.getValue(), DB_USER.getValue(), DB_PASSWORD.getValue());
    stmt =conn.createStatement();
    if (!tableExists(conn, "OPERATIONS"))
        stmt.execute("CREATE TABLE OPERATIONS (ID INT PRIMARY KEY AUTO_INCREMENT, FirstMathObject VARCHAR(30), MathOperation VARCHAR(30), SecondMathObject VARCHAR(30), Result VARCHAR(30) );");
        PreparedStatement ps = conn.prepareStatement("INSERT INTO OPERATIONS(FirstMathObject, MathOperation, SecondMathObject, Result) VALUES (?,?,?,?)");
        ps.setString(1,getFirstMathObject().toString());
        ps.setString(2,getMathOperation().toString());
        ps.setString(3,getSecondMathObject().toString());
        ps.setString(4,getResult().toString());
        ps.execute();

}catch(SQLException se) {
    se.printStackTrace();
} catch(Exception e) {
    e.printStackTrace();
} finally {
    try {
        if(stmt!=null) stmt.close();
    } catch(SQLException se2) {
    }
    try {
        if(conn!=null) conn.close();
    } catch(SQLException se) {
        se.printStackTrace();
    }
}

    }

    static boolean tableExists(Connection connection, String tableName) throws SQLException {
        DatabaseMetaData meta = connection.getMetaData();
        ResultSet resultSet = meta.getTables(null, null, tableName, new String[] {"TABLE"});
        return resultSet.next();
    }
}
