package thinking.machines;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.sql.*;
public class teacherOuterIterativeTag extends BodyTagSupport
{
private Connection connection;
private Statement s;
private ResultSet r;
private int count;
public int doStartTag() throws JspException
{
try
{
connection=GlobalResources.getConnection();
s=connection.createStatement();
r=s.executeQuery("select * from question");
count=0;
while(r.next()==true)
{
count++;
}
GlobalResources.teacherTotalNumberOfQuestion=count;
}catch(Exception e)
{
System.out.println(e);
}
return super.EVAL_BODY_INCLUDE;
}
public int doAfterBody() throws JspException 
{
if(GlobalResources.teacherTotalNumberOfQuestion==1)
{
return super.SKIP_BODY;
}
GlobalResources.teacherTotalNumberOfQuestion--;
return super.EVAL_BODY_AGAIN;
}
public int doEndTag() throws JspException
{
try
{
r.close();
s.close();
connection.close();
}catch(Exception e)
{
System.out.println(e);
}
return super.EVAL_PAGE;
}
}