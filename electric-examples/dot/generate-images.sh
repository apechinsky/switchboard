#!/bin/sh

# Generates documents from text data (puml, dot)
#
# Dependencies: 
#   - graphviz
#   - plantuml
#
# Workflow:
#  - change issue.dot
#  - run this script

error() {
    echo $1
    exit 1
}

command -v dot >/dev/null 2>&1 || error "Command 'dot' is not available.\nPossibly graphviz (http://www.graphviz.org/) is not installed."

find . -name "*.dot.png" -delete
find . -name "*.dot.svg" -delete
find . -name "*.puml.png" -delete

find . -name "*.dot" -exec dot -Tpng {} -o{}.png \;
find . -name "*.dot" -exec dot -Tsvg {} -o{}.svg \;
find . -name "*.puml" -exec plantuml -tpng {} {}.png \;


