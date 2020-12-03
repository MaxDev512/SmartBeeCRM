<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Show Data</title>
</head>
<body>
<table border="1" style="text-align: center; margin-left:auto; margin-right:auto;">
  <caption>Client 資料</caption>
  <thead>
    <tr>
      <th>Id</th>
      <th>Company Id</th>
      <th>Name</th>
      <th>Email</th>
      <th>Phone</th>
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
        <td>${data.company_id}</td>
        <td>${data.name}</td>
        <td>${data.email}</td>
        <td>${data.phone}</td>
        <td>${data.created_by}</td>
        <td>${data.created_at}</td>
        <td>${data.updated_by}</td>
        <td>${data.updated_at}</td>
      </tr>
    </#list>
  </tbody>
</table>
<div style="text-align: center">
  <a href="/func/show">回功能頁</a>
</div>
</body>
</html>
