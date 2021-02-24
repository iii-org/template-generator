package org.iiidevops.templateGenerator.step;

import org.iiidevops.templateGenerator.Constants;
import org.iiidevops.templateGenerator.arg.When;

import java.util.List;
import java.util.TreeMap;

public class BuildImageStep extends Step {
    public PublishImageConfig publishImageConfig;
    public TreeMap<String, Object> env;

    public BuildImageStep() {
        this.publishImageConfig = new PublishImageConfig();
        this.env = new TreeMap<>();
        this.env.put("PLUGIN_BUILD_ARGS", "--progress=tty --network=host");
        this.env.put("PLUGIN_DEBUG", true);
        this.env.put("PLUGIN_INSECURE", true);
        this.env.put("PLUGIN_MIRROR", "https://" + Constants.HARBOR_HOST);
        this.env.put("PLUGIN_MTU", 1000);
        this.when = new When("master", "develop");
    }
}

class PublishImageConfig {
    public String dockerfilePath = "./Dockerfile";
    public String buildContext = ".";
    public String tag = "${CICD_GIT_REPO_NAME}/${CICD_GIT_BRANCH}:latest";
    public boolean pushRemote = true;
    public String registry = Constants.HARBOR_HOST;
}

