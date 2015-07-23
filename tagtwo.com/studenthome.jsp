<%@taglib uri="/WEB-INF/tlds/MyTags.tld" prefix="mytags"%>
<%@ taglib prefix='c1' uri='http://java.sun.com/jsp/jstl/core' %>
<html>
<head>
<title>JSP Page</title>
</head>
<script language='javascript'>
function createTextArea(object)
{
var w=document.getElementById("ans_id").value;
var input = document.createElement("textarea");
input.rows='10';
input.columns='50';
input.id='text1';
var but=document.createElement("input");
but.type="button";
but.value="AddComment";
but.onclick=function()
{
var studentComment=document.getElementById("text1").value;
var hiddenForm=document.getElementById("hiddenCommentSubmitForm");
hiddenForm.comment.value=studentComment;
hiddenForm.answer_id.value=w;
hiddenForm.submit();
}
var x=document.getElementById(object);
x.appendChild(input);
x.appendChild(but);
}
</script>
<body>
<h1>start</h1>
<mytags:OuterIterativeTag>
<mytags:QuestionTag>
Question&nbsp;&nbsp;&nbsp;<%=question%>
<br>
SendTo&nbsp;&nbsp;&nbsp;<%=sendTo%>
<br>
-SendFrom&nbsp;&nbsp;&nbsp;<%=sendFrom%>
<c:set var="question_Id" value="<%=question_id%>"/>
<c:set var="isanswered" value="<%=isanswered%>"/>
<c:choose>
<c:when test="${isanswered=='0'}">
Answer not provided
<hr>
</c:when>
<c:otherwise>
<mytags:AnswerTag>
Answer&nbsp;&nbsp;&nbsp;<%=answer%>
<hr>
<mytags:CommentTag>
Comment:&nbsp;&nbsp;&nbsp;<%=comment%>
</mytags:CommentTag>
<hr>
<input type='button' value='addComment' onClick="createTextArea('answer_id')"/>
<span id='answer_id'>&nbsp;</span>
<input type='hidden' id='ans_id' value=<%=answer_id%>>
<hr>
</mytags:AnswerTag>
<hr>
</c:otherwise>
</c:choose>
</mytags:QuestionTag>
</mytags:OuterIterativeTag>
<form id='hiddenCommentSubmitForm' name='hiddenForm' action='/tagtwo.com/studentComment'>
<input type='hidden' id='answer_id' name='answer_id'>
<input type='hidden' id='comment' name='comment'>
</form>
</body>
</html>
