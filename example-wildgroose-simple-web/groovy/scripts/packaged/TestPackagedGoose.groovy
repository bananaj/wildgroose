
def goose = new packaged.PackagedGoose()

println """
<html>
    <head>
        <title>Groovy Servlet - Test Packaged Goose</title>
    </head>
    <body>
<h1>Test Packaged Goose</h1>
<p>Hello, ${request.remoteHost}: ${goose.honk()} ${new Date()}</p>
    </body>
</html>
"""