<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Modify</title>
</head>
<body style="height:100%">
  <table border="1" style="text-align: center; margin-left:auto; margin-right:auto;">
    <caption>刪除 Company 資料</caption>
    <thead>
    <tr>
      <th>Id</th>
      <th>Name</th>
      <th>Address</th>
      <th>Created By</th>
      <th>Created At</th>
      <th>Updated By</th>
      <th>Updated At</th>
    </tr>
    </thead>
    <tbody>
    <#list dataList as data>
      <tr>
        <td>${data.id}</td>
        <td>${data.name}</td>
        <td>${data.address}</td>
        <td>${data.created_by}</td>
        <td>${data.created_at}</td>
        <td>${data.updated_by}</td>
        <td>${data.updated_at}</td>
      </tr>
    </#list>
    </tbody>
  </table>
  <form action="/company/delete" method="post" style="position: relative; display: flex; align-items: center; height: 100%;">
    <table style="margin-left:auto; margin-right:auto; border: 0px; border-collapse: collapse;">
      <tr>
        <td>ID:</td>
        <td><input type="text" name="id"></td>
      </tr>
      <tr>
        <td style="text-align: center;"><input type="button" onclick="javascript:location.href='/func/show'" value="回功能頁"></td>
        <td style="text-align: center;"><input type="submit" value="確定"></td>
      </tr>
    </table>
  </form>
</body>
</html>
