<!DOCTYPE html>
<html lang="en" style="height: 100%;">
<head>
  <meta charset="UTF-8">
  <title>Index</title>
</head>
<body style="height:100%">
<#if Session.user??>
  <form action="/auth/logout" method="post" style="position: relative; display: flex; align-items: center; height: 100%;">
    <table style="margin-left:auto; margin-right:auto; border: 0px; border-collapse: collapse;">
      <tr><td colspan="2" style="text-align: center;"><a href="/func/show">功能頁面</a></td></tr>
      <tr><td colspan="2" style="text-align: center;"><input type="submit" value="登出"></td></tr>
    </table>
  </form>
<#else>
  <form action="/auth/login" method="post" style="position: relative; display: flex; align-items: center; height: 100%;">
    <table style="margin-left:auto; margin-right:auto; border: 0px; border-collapse: collapse;">
      <tr>
        <td colspan="2" style="text-align: center;">登入</td>
      </tr>
      <tr>
        <td>帳號:</td>
        <td><input type="text" name="id"></td>
      </tr>
      <tr>
        <td>密碼:</td>
        <td><input type="text" name="password"></td>
      </tr>
      <tr>
        <td colspan="2" style="text-align: center;"><input type="submit" value="登入"></td>
      </tr>
    </table>
  </form>
</#if>
</body>
</html>
