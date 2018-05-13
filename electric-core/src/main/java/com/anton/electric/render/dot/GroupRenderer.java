package com.anton.electric.render.dot;

import com.anton.electric.model.Group;
import com.anton.electric.render.IndentWriter;

/**
 * @author Q-APE
 */
public class GroupRenderer implements Renderer<Group> {

    @Override
    public void render(Group group, IndentWriter writer, DotSwitchboardRendererConfig config) {
        writer.println("subgraph cluster_%s {", group.id());

        writer.indentInc();

        writer.println("label=\"%s\";", group.name());
        writer.println("color=%s;", "grey");
        writer.println("style=filled;");

        group.getMembers().stream().forEach(member ->
            writer.println("%s;", member.id())
        );

        writer.indentDec();
        writer.println("}");
    }
}
