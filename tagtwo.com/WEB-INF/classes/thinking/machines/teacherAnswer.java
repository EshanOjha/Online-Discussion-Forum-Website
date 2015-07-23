package thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class  teacherAnswer extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String answer=request.getParameter("answer");
int questionId=Integer.parseInt(request.getParameter("question_id"));
Connection connection=GlobalResources.getConnection();
Statement s;
s=connection.createStatement();
PreparedStatement preparedStatement;
PreparedStatement preparedStatement1;
preparedStatement=connection.prepareStatement("insert into answer(answer,question_id) values(?,?)");
preparedStatement.setString(1,answer);
preparedStatement.setInt(2,questionId);
preparedStatement.executeUpdate();
preparedStatement1=connection.prepareStatement("update question set isanswered=? where question_id=?");
preparedStatement1.setInt(1,1);
preparedStatement1.setInt(2,questionId);
preparedStatement1.executeUpdate();
preparedStatement.close();
preparedStatement1.close();
connection.close();
System.out.println("record inserted");
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/teacherhome.jsp");
requestDispatcher.forward(request,response);
}catch(Exception e)
{
System.out.println(e);
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}