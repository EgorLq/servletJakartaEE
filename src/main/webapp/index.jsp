<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Name Form</title>
</head>
<body>
<h1>Add Name from DB</h1>
<h1>What's your name?</h1>

<form action="/JavaWorkServlet_war_exploded/hello-servlet" method="POST">
    <input type="text" name="name" value="Eva">
    <br><br>
    <input type="submit" value="Submit">
</form>
<pre>  </pre>
<form action="/JavaWorkServlet_war_exploded/data-Base" method="POST">
    <h1>Database information</h1>
    <br><br>
    <input type="submit" value="Submit">
</form>
<pre>  </pre>
<h2>Products List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
    <tr><th>Name</th><th></th></tr>
    <c:forEach var="product" items="${products}">
        <tr><td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <a href='<c:url value="/edit?id=${product.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${product.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>
<pre>  </pre>
<h3>New product</h3>
<form  method="post">
    <label>Name</label><br>
    <input name="name"/><br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>