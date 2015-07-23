<%@taglib uri="/WEB-INF/tlds/MyTags.tld" prefix="mytags"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>
<title>JSP Page</title>
</head>
<script language='javascript'>
function createTextArea(object)
{
var w=document.getElementById("qu_id").value;
var input = document.createElement("textarea");
input.rows='10';
input.columns='50';
input.id='text1';
var but=document.createElement("input");
but.type="button";
but.value="AddAnswer";
but.onclick=function()
{
var teacherAnswer=document.getElementById("text1").value;
var hiddenForm=document.getElementById("hiddenAnswerSubmitForm");
hiddenForm.answer.value=teacherAnswer;
hiddenForm.question_id.value=w;
hiddenForm.submit();
}
var x=document.getElementById(object);
x.appendChild(input);
x.appendChild(but);
}
</script>
<body>
<h1>start</h1>
<mytags:teacherOuterIterativeTag>
<mytags:teacherQuestionTag>
Question&nbsp;&nbsp;&nbsp;<%=question%>
<br>
SendFrom&nbsp;&nbsp;&nbsp;<%=sendFrom%>
<br>
<c:set var="isanswered" value="<%=isanswered%>"/>
<c:set var="question_Id" value="<%=questionId%>"/>
<c:choose>
<c:when test="${isanswered=='0'}">
<input type='button' value='addAnswer' onClick="createTextArea('question_Id')"/>
<span id='question_Id'>&nbsp;</span>
<input type='hidden' id='qu_id' value=<%=questionId%>>
</c:when>
<c:otherwise>
<mytags:teacherAnswerTag>
answer&nbsp;&nbsp;&nbsp;<%=answer%>
<br>
<hr>
</mytags:teacherAnswerTag>
</c:otherwise>
</c:choose>
<hr>
</mytags:teacherQuestionTag>
</mytags:teacherOuterIterativeTag>
<form id='hiddenAnswerSubmitForm' name='hiddenForm' action='/tagtwo.com/teacherAnswer'>
<input type='hidden' id='question_id' name='question_id'>
<input type='hidden' id='answer' name='answer'>
</form>
</body>
</html>
