
def goose = new Goose()

println """
<html>
    <head>
        <title>Groovy Servlet - Test Packaged</title>
    </head>
    <body>
<h1>Test Packaged</h1>
<p>Hello, ${request.remoteHost}: ${goose.honk()} ${new Date()}</p>
    </body>
</html>
"""