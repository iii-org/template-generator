package org.iiidevops.templateGenerator.stage;

import org.iiidevops.templateGenerator.step.WaitDeployStep;

public class WaitDeployStage extends Stage {
    public WaitDeployStage(String name, String suffix) {
        this.name = name;
        this.steps.add(new WaitDeployStep(suffix));
    }
}
