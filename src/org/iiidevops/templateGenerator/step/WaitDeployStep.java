package org.iiidevops.templateGenerator.step;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.iiidevops.templateGenerator.Constants;
import org.iiidevops.templateGenerator.arg.EnvFrom;
import org.iiidevops.templateGenerator.arg.When;

import java.util.TreeMap;

@JsonPropertyOrder({"runScriptConfig", "env", "envFrom", "when"})
public class WaitDeployStep extends Step {
    public RunScriptConfig runScriptConfig;
    public TreeMap<String, Object> env;
    public EnvFrom envFrom;

    public WaitDeployStep(String deployName) {
        this.runScriptConfig = new RunScriptConfig();
        this.env = new TreeMap<>();
        this.env.put("namespace", "${CICD_GIT_REPO_NAME}");
        this.env.put("deploy_name", "${CICD_GIT_REPO_NAME}-${CICD_GIT_BRANCH}-" + deployName);
        this.env.put("max_wait", 128);
        this.envFrom = new EnvFrom();
        this.envFrom.addEnv("pipeline-api-key", "API_TOKEN", "rancher_api_token");
        this.envFrom.addEnv("rancher", "rancher-url", "rancher_url");
        this.when = new When("master", "develop");
    }

    static class RunScriptConfig {
        public String image = "iiiorg/deployment-waiter:" + Constants.DEPLOYMENT_WAITER_VERSION;
        public String shellScript = "rancher login ${rancher_url} -t ${rancher_api_token} --skip-verify;\nbash /app/run.sh;";
    }
}
