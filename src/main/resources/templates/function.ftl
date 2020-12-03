<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Operations</title>
</head>
<body>
<table border="0" style="text-align: center;">
  Role:
  <#if permission == 0>
    Super user
  <#elseif permission == 1>
    Manager
  <#else>
    Operator
  </#if>
  <tr><th>Company</th></tr>
  <tr><td><a href="/company/view">Show Data</a></td></tr>
  <#if permission == 0 || permission == 2>
  <tr><td><a href="/company/create">Create Data</a></td></tr>
  </#if>
  <#if permission == 0 || permission == 1>
    <tr><td><a href="/company/modify">Modify Data</a></td></tr>
    <tr><td><a href="/company/delete">Delete Data</a></td></tr>
  </#if>
  <tr><td>　</td></tr>
  <tr><td>　</td></tr>
  <tr><th>Client</th></tr>
  <tr><td><a href="/client/view">Show Data</a></td></tr>
  <#if permission == 0 || permission == 2>
    <tr><td><a href="/client/create">Create Data</a></td></tr>
  </#if>
  <#if permission == 0 || permission == 1>
    <tr><td><a href="/client/modify">Modify Data</a></td></tr>
    <tr><td><a href="/client/delete">Delete Data</a></td></tr>
  </#if>
</table>
<div style="text-align: center">
  <a href="/">回首頁</a>
</div>
</body>
</html>
