package com.anton.electric.render;

import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.Writer;

import com.google.common.base.Strings;

/**
 * @author Q-APE
 */
public class IndentWriter {

    private PrintWriter writer;

    private int level;

    public IndentWriter(Writer writer) {
        this.writer = new PrintWriter(new BufferedWriter(writer));
        this.level = 0;
    }

    public IndentWriter printf(String pattern, Object... arguments) {
        writer.print(getIndent(level));
        writer.printf(pattern, arguments);
        return this;
    }

    public IndentWriter println(String pattern, Object... arguments) {
        return printf(pattern + "%n", arguments);
    }

    public void flush() {
        writer.flush();
    }

    public void indent(int level) {
        this.level = 0;
    }

    public void indentInc() {
        level++;
    }

    public void indentDec() {
        level--;
    }

    private static String getIndent(int depth) {
        return Strings.repeat(" ", depth * 4);
    }
}
