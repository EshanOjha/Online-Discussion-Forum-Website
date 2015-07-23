package thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class studentComment extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String comment=request.getParameter("comment");
int answerId=Integer.parseInt(request.getParameter("answer_id"));
Connection connection=GlobalResources.getConnection();
Statement s;
s=connection.createStatement();
PreparedStatement preparedStatement;
PreparedStatement preparedStatement1;
preparedStatement=connection.prepareStatement("insert into comment(comment,answer_id) values(?,?)");
preparedStatement.setString(1,comment);
preparedStatement.setInt(2,answerId);
preparedStatement.executeUpdate();
preparedStatement.close();
connection.close();
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/studenthome.jsp");
requestDispatcher.forward(request,response);
}catch(Exception e)
{
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}