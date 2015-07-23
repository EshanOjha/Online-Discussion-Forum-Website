package thinking.machines;
import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;
public class teacherQuestionTagTEI extends TagExtraInfo
{
public VariableInfo[] getVariableInfo(TagData data)
{
VariableInfo []v;
v=new VariableInfo[4];
v[0]=new VariableInfo("question","java.lang.String",true,VariableInfo.NESTED);

v[1]=new VariableInfo("sendFrom","java.lang.String",true,VariableInfo.NESTED);

v[2]=new VariableInfo("isanswered","java.lang.Integer",true,VariableInfo.NESTED);
v[3]=new VariableInfo("questionId","java.lang.Integer",true,VariableInfo.NESTED);

return v;

}
}
