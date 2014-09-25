
def goose = new Goose()

println """
<html>
    <head>
        <title>Groovy Servlet - Test</title>
    </head>
    <body>
<h1>Test</h1>
<p>Hello, ${request.remoteHost}: ${goose.honk()} ${new Date()}</p>
    </body>
</html>
"""