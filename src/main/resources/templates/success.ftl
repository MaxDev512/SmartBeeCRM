<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Success</title>
</head>
<body>
<h1>Success</h1>
<#if functionId == 1>
建立${title}資料成功
<#elseif functionId == 2>
修改${title}資料成功
<#elseif functionId == 3>
刪除${title}資料成功
</#if>

<div style="text-align: center">
  <a href="/func/show">回功能頁</a>
</div>
</body>
</html>
