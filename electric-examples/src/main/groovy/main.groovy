import com.anton.electric.dsl.SwitchboardLoader
import com.anton.electric.render.dot.DotSwitchboardRenderer

def switchboard = SwitchboardLoader.loadFile("config.groovy")

println switchboard

def renderer = new DotSwitchboardRenderer(System.out, "Electric")
renderer.render(switchboard)


