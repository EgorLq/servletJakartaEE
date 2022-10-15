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
<form action="/JavaWorkServlet_war_exploded/products1" >
    <h1>Database information</h1>
    <br><br>
    <input type="submit" value="Submit">
</form>
<pre>  </pre>
<form action="./InsertData" method="post">
    <p>ID:</p>
    <!-- Create an element with mandatory name attribute,
    so that data can be transfer to the servlet using getParameter() -->
    <input type="text" name="id"/>
    <br/>
    <p>String:</p>
    <input type="text" name="string"/>
    <br/><br/><br/>
    <input type="submit"/>
</form>
<pre>  </pre>
<form action="/JavaWorkServlet_war_exploded/test-servlet" >
    <input type="submit" value="Submit">
</form>
</body>
</html>