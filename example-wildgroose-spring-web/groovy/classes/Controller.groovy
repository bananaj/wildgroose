class Controller {
    /**
     * This method accepts a closure which is essentially the DSL. Delegate the closure methods to
     * the DSL class so the calls can be processed
     */
    def static process(applicationContext, Map closures) {
        def binding = new Binding()
        closures.injections.each { i ->
            def name = "${i}"
            def value = applicationContext.getBean(name)
            binding.setVariable(name, value)
        }
        closures.handler.delegate = binding
        closures.handler()
        // closures.handler()
    }
}