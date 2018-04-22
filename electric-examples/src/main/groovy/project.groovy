import com.anton.electric.render.dot.DotSwitchboardRenderer

def switchboard = switchboard("config.groovy")

println switchboard

def renderer = new DotSwitchboardRenderer(System.out, "Electric")
renderer.render(switchboard)


