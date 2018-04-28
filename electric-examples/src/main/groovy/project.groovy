import com.anton.electric.render.dot.DotSwitchboardRenderer

def switchboard = switchboard("config.groovy")

def workDir = new File('/home/apechinsky/work/my/github/switchboard/build')
def dotFile = new File(workDir, 'electric.dot')

dotFile.withWriter { writer ->
    def renderer = new DotSwitchboardRenderer(writer, "Electric")
    renderer.render(switchboard)
}

println switchboard

"dot -Tpng ${dotFile} -o ${dotFile}.png".execute()

println new Consumers().count()

