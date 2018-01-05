<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>mvc test</title>
</head>
<body>
<#--show info ${books}-->
<#--<#if (books ==null)>-->
    <#--books is list-->
<#--</#if>-->
<#list books as book>
    ${book.id}
    ${book.name}
    ${book.author}
</#list>
</body>
</html>