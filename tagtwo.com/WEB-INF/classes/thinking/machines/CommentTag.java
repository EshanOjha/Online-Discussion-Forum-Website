package thinking.machines;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.sql.*;
public class CommentTag extends TagSupport
{
private int answerId;
private Connection connection;
private ResultSet r;
private PreparedStatement preparedStatement;
public int doStartTag() throws JspException
{
try
{
connection=GlobalResources.getConnection();
int answerId=GlobalResources.studentAnswerId;
String sql="select * from comment where answer_id=?";
preparedStatement=connection.prepareStatement(sql);
preparedStatement.setInt(1,answerId);
r=preparedStatement.executeQuery();
String comment;
while(r.next()==true)
{
comment=r.getString("comment");
pageContext.setAttribute("comment",comment);
}
}catch(Exception e)
{
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
}
return super.EVAL_PAGE;

}
}