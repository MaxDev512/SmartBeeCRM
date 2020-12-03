<!DOCTYPE html>
<html lang="en" style="height:100%">
<head>
  <meta charset="UTF-8">
  <title>Modify</title>
</head>
<body style="height:100%">
  <form action="/company/create" method="post" style="position: relative; display: flex; align-items: center; height: 100%;">
    <table style="margin-left:auto; margin-right:auto; border: 0px; border-collapse: collapse;">
      <caption>建立 Company 資料</caption>
      <tr>
        <td>Name:</td>
        <td><input type="text" name="name"></td>
      </tr>
      <tr>
        <td>Address:</td>
        <td><input type="text" name="address"></td>
      </tr>
      <tr>
        <td style="text-align: center;"><input type="button" onclick="javascript:location.href='/func/show'" value="回功能頁"></td>
        <td style="text-align: center;"><input type="submit" value="確定"></td>
      </tr>
    </table>
  </form>
</body>
</html>
