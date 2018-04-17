import builder.com.anton.electric.dsl.SwitchboardLoader
import com.anton.electric.render.dot.DotSwitchboardRenderer

def switchboard = new File("config.groovy").withReader { reader ->
    return new SwitchboardLoader().load(reader)
}

println switchboard

def renderer = new DotSwitchboardRenderer(System.out, "Electric")
renderer.render(switchboard)


