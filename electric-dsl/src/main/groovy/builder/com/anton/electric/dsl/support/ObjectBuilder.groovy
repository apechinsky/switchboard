package builder.com.anton.electric.dsl.support

/**
 *
 * @author Q-APE
 */
class ObjectBuilder<T> extends GroovyObjectSupport {

    Class<T> type

    String id

    ObjectRegistry registry

    Map properties = [:]

    private def resolved

    def methodMissing(String id, args) {
        this."$id" = args[0]
    }

    @Override
    Object getProperty(String property) {
        try {
            return super.getProperty(property)
        }
        catch (MissingPropertyException e) {
            return properties[ property ]
        }
    }

    @Override
    void setProperty(String property, Object newValue) {
        try {
            super.setProperty(property, newValue)
        }
        catch (MissingPropertyException e) {
            properties[ property ] = newValue
        }
    }

    T build() {
        Map constructorMap = [id: id]
        constructorMap + properties
        return type.newInstance(constructorMap)
    }

    def getResolved() {
        if (resolved == null) {
            resolved = build();
        }
        return resolved
    }

    boolean equals(o) {
        if (this.is(o)) {
            return true
        }
        if (getClass() != o.class) {
            return false
        }

        ObjectBuilder that = (ObjectBuilder) o

        return id == that.id && type == that.type
    }

    int hashCode() {
        int result = 1;
        result = 31 * result + (id != null ? id.hashCode() : 0)
        result = 31 * result + (type != null ? type.hashCode() : 0)
        return result
    }

}
