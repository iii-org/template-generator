package org.iiidevops.templateGenerator.answers;

import org.iiidevops.templateGenerator.stage.DeployWebStage;
import org.iiidevops.templateGenerator.stage.TestPostmanStage;

public class TestPostmanAnswers extends PipeSeqAnswers {
    public TestPostmanAnswers(int port) {
        this.put("web.deployName", "${CICD_GIT_REPO_NAME}-${CICD_GIT_BRANCH}-"
                + DeployWebStage.SUFFIX);
        this.put("web.port", port);
    }
}
