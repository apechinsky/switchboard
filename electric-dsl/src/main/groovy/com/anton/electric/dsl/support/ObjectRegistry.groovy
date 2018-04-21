package com.anton.electric.dsl.support

import org.codehaus.groovy.control.ConfigurationException

/**

 * @author Q-APE
 */
class ObjectRegistry {

    private Set<ObjectBuilder> builders = []

    ObjectBuilder register(ObjectBuilder builder) {
        builders.add(builder)
        return builder
    }

    ObjectBuilder register(Class clazz) {
        return register(new ObjectBuilder(type: clazz))
    }

    ObjectBuilder find(ObjectReference reference) {
        builders.find {builder ->
            builder.type == reference.type && builder.id == reference.id
        }
    }

    List<ObjectBuilder> find(Collection<ObjectReference> references) {
        return references.collect() { reference ->
            ObjectBuilder builder = find(reference)

            if (!builder) {
                throw new ConfigurationException("Can't resolve reference: ${reference}")
            }

            return builder
        }
    }

    def resolve(ObjectBuilder builder) {
        builder.resolved(builder.build())
    }

    List getResolved(Collection<ObjectBuilder> builders) {
        return builders.collect { resolve(it) }
    }

    List getResolvedReferences(Collection<ObjectReference> references) {
        return getResolved(find(references))
    }

    List get(Class clazz) {
        return builders
            .findAll { it.type == clazz }
            .collect { it.getResolved() }
    }


}
