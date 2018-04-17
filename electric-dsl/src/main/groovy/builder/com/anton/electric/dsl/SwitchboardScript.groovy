package builder.com.anton.electric.dsl

/**
 * @author Q-APE
 */
abstract class SwitchboardScript extends Script {

    def switchboard(Closure closure) {
        binding.builder = new SwitchboardBuilder()
        configure(closure, binding.builder)
    }

    def configure(Closure closure, def delegate) {
        closure.delegate = delegate
        closure.setResolveStrategy(Closure.DELEGATE_FIRST)
        closure.call()
    }
    private boolean isMethodWithSoleClosure(args) {
        args.length == 1 && (args[0] instanceof Closure)
    }

}
