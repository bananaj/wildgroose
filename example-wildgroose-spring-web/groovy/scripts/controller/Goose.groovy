Controller.process (applicationContext, [
        injections: ["gooseService"],
        handler: {
            println "handler"
            println "x: " + gooseService.getHonk()
        }
])