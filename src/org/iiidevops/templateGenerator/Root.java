package org.iiidevops.templateGenerator;

import org.iiidevops.templateGenerator.stage.BuildImageStage;
import org.iiidevops.templateGenerator.stage.DeployDbStage;
import org.iiidevops.templateGenerator.stage.ScanCheckmarxStage;
import org.iiidevops.templateGenerator.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Root {
    public List<Stage> stages = new ArrayList<>();

    public Root(Target target) {
        if (target.isBuildImage()) {
            this.stages.add(new BuildImageStage());
        }
        if (target.isScanCheckmarx()) {
            this.stages.add(new ScanCheckmarxStage());
        }
        if (target.isDeployDb()) {
            Target.DbArguments args = target.getDbArguments();
            this.stages.add(new DeployDbStage(args.dbType.name(), args.dbTag));
            // this.stages.add(new WaitDeployDbStage());
        }
    }
}
