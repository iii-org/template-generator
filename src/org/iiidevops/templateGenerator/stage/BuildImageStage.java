package org.iiidevops.templateGenerator.stage;

import org.iiidevops.templateGenerator.step.BuildImageStep;

import java.util.ArrayList;

public class BuildImageStage extends Stage {
    public BuildImageStage() {
        this.name = "Build--Build and push docker image";
        this.steps.add(new BuildImageStep());
    }
}
