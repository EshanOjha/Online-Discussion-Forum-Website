package thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class AddQuestion extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
try
{
String askTo=request.getParameter("askTo");
String question=request.getParameter("question");
System.out.println(askTo);
System.out.println(question);
Connection connection=GlobalResources.getConnection();
Statement s;
s=connection.createStatement();
s.executeUpdate("insert into question(question,sendTo,sendBy,isanswered) values('"+question+"','"+askTo+"','eshan',0)");
s.close();
connection.close();
System.out.println("record inserted");
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/AskQuestion.html");
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