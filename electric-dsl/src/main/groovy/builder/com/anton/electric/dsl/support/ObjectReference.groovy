package builder.com.anton.electric.dsl.support

/**
 *
 * @author Q-APE
 */
class ObjectReference {

    private Class type

    private String id

    ObjectReference(Class type, String id) {
        this.type = type
        this.id = id
    }

    Class getType() {
        return type
    }

    String getId() {
        return id
    }

    @Override
    public String toString() {
        return "ObjectReference [${type.simpleName} : $id]"
    }
}
