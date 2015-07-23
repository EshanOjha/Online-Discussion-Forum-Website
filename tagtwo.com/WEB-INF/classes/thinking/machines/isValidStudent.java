package thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
public class isValidStudent extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
String username=request.getParameter("studentUsername");
String password=request.getParameter("studentPassword");
if(username.equals("eshan") && password.equals("ojha"))
{
try
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/studenthome.jsp");
requestDispatcher.forward(request,response);
}catch(Exception e)
{
System.out.println(e);
}
}
else
{
try
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/home.jsp");
requestDispatcher.forward(request,response);
}catch(Exception e)
{
System.out.println(e);
}
}
}
public void doPost(HttpServletRequest request,HttpServletResponse response)
{
doGet(request,response);
}
}
