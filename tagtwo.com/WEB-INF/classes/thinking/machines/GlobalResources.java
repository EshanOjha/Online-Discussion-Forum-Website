package thinking.machines;
import java.sql.*;
public class GlobalResources
{
public static int studentAnswerId;
public static int teacherQuestionId;
public static int teacherTotalNumberOfQuestion;
public static int totalNumberOfQuestion;
public static Connection getConnection()
{
Connection connection=null;
try
{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
connection=DriverManager.getConnection("jdbc:odbc:tmdsn","uec","uec");
}catch(Exception e)
{
System.out.println(e);
}
return connection;
}

}