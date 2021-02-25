package org.iiidevops.templateGenerator.answers;

import org.iiidevops.templateGenerator.Constants;
import org.iiidevops.templateGenerator.stage.DeployDbStage;

public class WebAnswers extends GitAnswers {
    public WebAnswers(int port) {
        this.put("harbor.host", Constants.HARBOR_HOST);
        this.put("web.port", port);
        this.put("web.imageTag", Constants.BUILD_IMAGE_TAG);
    }

    public void useDb() {
        this.put("db.releaseName", "${CICD_GIT_REPO_NAME}-${CICD_GIT_BRANCH}-"
                + DeployDbStage.SUFFIX);
        this.put("db.username", Constants.DEFAULT_DB_USERNAME);
        this.put("db.password", Constants.DEFAULT_DB_PASSWORD);
        this.put("db.name", Constants.DEFAULT_DB_NAME);
    }
}
