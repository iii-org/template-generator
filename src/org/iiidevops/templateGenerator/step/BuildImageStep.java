package org.iiidevops.templateGenerator.step;

import org.iiidevops.templateGenerator.Constants;
import org.iiidevops.templateGenerator.arg.Env;
import org.iiidevops.templateGenerator.arg.When;

import java.util.List;

public class BuildImageStep extends Step {
    public PublishImageConfig publishImageConfig;
    public Env env;

    public BuildImageStep() {
        publishImageConfig = new PublishImageConfig();
        env = new BuildImageEnv();
        when = new When(List.of("master", "develop"));
    }
}

class PublishImageConfig {
    public String dockerfilePath = "./Dockerfile";
    public String buildContext = ".";
    public String tag = "${CICD_GIT_REPO_NAME}/${CICD_GIT_BRANCH}:latest";
    public boolean pushRemote = true;
    public String registry = Constants.HARBOR_HOST;
}

class BuildImageEnv extends Env {
    public String PLUGIN_BUILD_ARGS = "--progress=tty --network=host";
    public String PLUGIN_DEBUG = "true";
    public String PLUGIN_INSECURE = "true";
    public String PLUGIN_MIRROR = "https://" + Constants.HARBOR_HOST;
    public String PLUGIN_MTU = "1000";
}
