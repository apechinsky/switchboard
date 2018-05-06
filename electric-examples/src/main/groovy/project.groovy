import com.anton.electric.model.Switchboard
import com.anton.electric.render.dot.DotSwitchboardRenderer
import com.anton.electric.render.dot.DotSwitchboardRendererConfig

def consumers = new MyConsumers()

println "Consumers: ${consumers.count()}"


process(  switchboard("config.groovy") )

process( switchboard("configDiff.groovy") )

def process(Switchboard switchboard) {
    def workDir = new File('/home/apechinsky/work/my/github/switchboard/build')

    def dotFile = new File(workDir, "switchboard${switchboard.getName()}.dot")

    dotFile.withWriter { writer ->
        def config = new DotSwitchboardRendererConfig()
        config.setRenderGroundLinks(false)
        config.setRenderId(false)

        def renderer = new DotSwitchboardRenderer(writer, "Electric", config)
        renderer.render(switchboard)
    }

    println switchboard

    "dot -Tpng ${dotFile} -o ${dotFile}.png".execute()
    "dot -Tsvg ${dotFile} -o ${dotFile}.svg".execute()

}

