package thinking.machines;
import javax.servlet.jsp.tagext.TagData;
import javax.servlet.jsp.tagext.TagExtraInfo;
import javax.servlet.jsp.tagext.VariableInfo;
public class commentTagTEI extends TagExtraInfo
{
public VariableInfo[] getVariableInfo(TagData data)
{
VariableInfo []v;
v=new VariableInfo[1];
v[0]=new VariableInfo("comment","java.lang.String",true,VariableInfo.NESTED);

return v;

}
}
