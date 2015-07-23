package thinking.machines;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.sql.*;
public class QuestionTag extends TagSupport
{
private Connection connection;
private Statement statement;
private ResultSet resultSet;
public int doStartTag() throws JspException
{
try
{
connection=GlobalResources.getConnection();
statement=connection.createStatement();
resultSet=statement.executeQuery("select * from question where question_id="+GlobalResources.totalNumberOfQuestion);
if(resultSet.next()==false)
{
return super.SKIP_BODY;
}
int question_id=resultSet.getInt("question_id");
String question=resultSet.getString("question");
String sendTo=resultSet.getString("sendTo");
String sendBy=resultSet.getString("sendBy");
int isanswered=resultSet.getInt("isanswered");
pageContext.setAttribute("question",question);
pageContext.setAttribute("sendTo",sendTo);
pageContext.setAttribute("sendFrom",sendBy);
pageContext.setAttribute("question_id",question_id);
pageContext.setAttribute("isanswered",isanswered);
}catch(Exception e)
{
System.out.println(e);
}
return super.EVAL_BODY_INCLUDE;
}
public int doEndTag() throws JspException
{
try
{
resultSet.close();
statement.close();
connection.close();
}catch(Exception e)
{
}
return super.EVAL_PAGE;
}
}