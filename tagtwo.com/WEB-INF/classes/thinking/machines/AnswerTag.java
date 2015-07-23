package thinking.machines;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.sql.*;
public class AnswerTag extends TagSupport
{
private int questionId;
private int answerId;
private Connection connection;
private PreparedStatement preparedStatement;
private ResultSet r;
public int doStartTag() throws JspException
{
try
{
questionId=GlobalResources.totalNumberOfQuestion;
connection=GlobalResources.getConnection();
String sql="select * from answer where question_id=?";
preparedStatement=connection.prepareStatement(sql);
preparedStatement.setInt(1,questionId);
r=preparedStatement.executeQuery();
String answer;
int answerId;
while(r.next()==true)
{
answer=r.getString("answer");
answerId=r.getInt("answer_id");
GlobalResources.studentAnswerId=answerId;
pageContext.setAttribute("answer",answer);
pageContext.setAttribute("answer_id",answerId);
}
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
r.close();
preparedStatement.close();
connection.close();
}catch(Exception e)
{
System.out.println(e);
}
return super.EVAL_PAGE;
}
}