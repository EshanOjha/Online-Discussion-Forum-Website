<html>
<head>
<title></title>
<script language='javascript'>
function checkStudentLogin(frm)
{
var authentic=true;
var usm=frm1.studentUsername.value;
var pwd=frm1.studentPassword.value;
if(usm.length==0)
{
document.getElementById("studentUsernameErrorSection").innerHTML='required';
authentic=false;
}
if(pwd.length==0)
{
document.getElementById("studentPasswordErrorSection").innerHTML='required';
authentic=false;
}
return authentic;
}
function checkTeacherLogin(frm1)
{
var authentic=true;
var usm=frm1.teacherUsername.value;
var pwd=frm1.teacherPassword.value;
if(usm.length==0)
{
document.getElementById("teacherUsernameErrorSection").innerHTML='required';
authentic=false;
}
if(pwd.length==0)
{
document.getElementById("teacherPasswordErrorSection").innerHTML='required';
authentic=false;
}
return authentic;
}
</script>
</head>
<body>
<h1>Student Authentication</h1>
<form action='/tagtwo.com/isValidStudent' onsubmit='return checkStudentLogin(this)'>
<table border='0'>
<tbody>
<tr>
<td>Username</td>
<td><input type="text" name="studentUsername" id="studentUsername" value=""/>
<span id="studentUsernameErrorSection"></span>
</td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="studentPassword" id="studentPassword" value="" />
<span id="studentPasswordErrorSection"></span>
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Login" /></td>
</tr>
</tbody>
</table>
</form>
<h1>Teacher Authentication Form</h1>
<form action='/tagtwo.com/isValidTeacher' onsubmit='return checkTeacherLogin(this)'>
<table border='0'>
<tbody>
<tr>
<td>Username</td>
<td><input type="text" name="teacherUsername" id="teacherUsername" value=""/>
</td>
<td>
<span id="teacherUsernameErrorSection"></span>
</td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="teacherPassword" id="teacherPassword" value="" />
</td>
<td>
<span id="teacherPasswordErrorSection"></span>
</td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Login" /></td>
</tr>
</tbody>
</table>
</form>
</body>
</html>