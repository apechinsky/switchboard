package com.anton.electric.model;

import java.util.Set;

/**
 * @author Q-APE
 */
public class Group extends AbstractComponent {

    private Set<Component> members;

    public Group(String id, String name, Set<Component> members) {
        super(id, name, 0, 0, 0);
        this.members = members;
    }

    public Set<Component> getMembers() {
        return members;
    }

}
