package org.iiidevops.templateGenerator.answers;

import org.iiidevops.templateGenerator.stage.DeployWebStage;

public class TestWebinspectAnswers extends PipeSeqAnswers {
    public TestWebinspectAnswers() {
        this.put("web.deployName", "${CICD_GIT_REPO_NAME}-${CICD_GIT_BRANCH}-"
                + DeployWebStage.SUFFIX);
    }
}
