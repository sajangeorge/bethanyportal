
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html><head>
<meta http-equiv="content-type" content="text/html; charset=ISO-8859-1"><title>Bethany</title>

</head><body>
<table style="text-align: left; width: 100%; height: 570px;" border="1" cellpadding="2" cellspacing="2">
<tbody>
<tr height="15%">
<td style="width: 100%; text-align: center;" colspan="2" rowspan="1">
<div style="margin-left: 80px;">BETHANY WEBSITE</div>
</td>
</tr>
<tr height="70%">
<td style="width: 20%;">
<jsp:include page="./navigation.jsp" />
</td>
<td width="80%">
<s:actionerror />
<s:actionmessage />
<s:form action="login" method="post">
    <s:textfield name="username" label="User ID" size="20" />
    <s:password name="password" label="Password"  size="20" />
    <s:submit method="execute" label="Login"  align="center" />
</s:form>
</td>
</tr>
<tr height="15%">
<td style="width: 100%; text-align: center;" colspan="2" rowspan="1">FOOTER PAGE</td>
</tr>
</tbody>
</table>
<br>
</body></html>
