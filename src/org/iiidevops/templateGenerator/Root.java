package org.iiidevops.templateGenerator;

import org.iiidevops.templateGenerator.stage.*;

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
            this.stages.add(new DeployDbStage(args.dbType.name(), args.dbImageTag));
            this.stages.add(new WaitDeployStage("Wait db deployment", DeployDbStage.SUFFIX));
        }
        if (target.isDeployWeb()) {
            Target.WebArguments args = target.getWebArguments();
            this.stages.add(new DeployWebStage(args.port, target.isDeployDb()));
            this.stages.add(new WaitDeployStage("Wait web deployment", DeployWebStage.SUFFIX));
        }
        if (target.isTestPostman()) {
            Target.WebArguments args = target.getWebArguments();
            this.stages.add(new TestPostmanStage(args.port));
        }
        if (target.isTestWebinspect()) {
            this.stages.add(new TestWebinspectStage());
        }
    }
}
