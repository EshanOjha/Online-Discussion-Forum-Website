package thinking.machines;
import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;
public class AnswerTagTEI extends TagExtraInfo
{
public VariableInfo[] getVariableInfo(TagData data)
{
VariableInfo []v;
v=new VariableInfo[2];
v[0]=new VariableInfo("answer","java.lang.String",true,VariableInfo.NESTED);
v[1]=new VariableInfo("answer_id","java.lang.Integer",true,VariableInfo.NESTED);

return v;

}
}
