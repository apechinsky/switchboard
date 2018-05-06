package com.anton.electric.render.dot;

/**
 * @author Q-APE
 */
public class DotSwitchboardRendererConfig {

    private boolean renderGroundLinks;

    private boolean renderId;

    public boolean isRenderGroundLinks() {
        return renderGroundLinks;
    }

    public DotSwitchboardRendererConfig setRenderGroundLinks(boolean renderGroundLinks) {
        this.renderGroundLinks = renderGroundLinks;
        return this;
    }

    public boolean isRenderId() {
        return renderId;
    }

    public DotSwitchboardRendererConfig setRenderId(boolean renderId) {
        this.renderId = renderId;
        return this;
    }
}
