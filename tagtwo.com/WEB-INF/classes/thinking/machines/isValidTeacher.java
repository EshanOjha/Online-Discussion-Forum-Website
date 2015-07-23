package thinking.machines;
import javax.servlet.*;
import javax.servlet.http.*;
public class isValidTeacher extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)
{
String username=request.getParameter("teacherUsername");
String password=request.getParameter("teacherPassword");
if(username.equals("aaa") && password.equals("bbb"))
{
try
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/teacherhome.jsp");
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
