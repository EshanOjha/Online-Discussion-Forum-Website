package thinking.machines;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.sql.*;
public class teacherAnswerTag extends TagSupport
{
private Connection connection;
private Statement statement;
public int doStartTag() throws JspException
{
try
{
int questionId=GlobalResources.teacherQuestionId;
Connection connection=GlobalResources.getConnection();
String sql="select * from answer where question_id=?";
PreparedStatement preparedStatement=connection.prepareStatement(sql);
preparedStatement.setInt(1,questionId);

ResultSet r=preparedStatement.executeQuery();
String answer;
while(r.next()==true)
{
answer=r.getString("answer");
pageContext.setAttribute("answer",answer);
System.out.println(answer);
}
r.close();
preparedStatement.close();
connection.close();



}catch(Exception e)
{
System.out.println(e);
}
return super.EVAL_BODY_INCLUDE;
}
public int doEndTag() throws JspException
{
return super.EVAL_PAGE;
}
}