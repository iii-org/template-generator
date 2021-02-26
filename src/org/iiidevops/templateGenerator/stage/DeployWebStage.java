package org.iiidevops.templateGenerator.stage;

import org.iiidevops.templateGenerator.Constants;
import org.iiidevops.templateGenerator.answers.WebAnswers;
import org.iiidevops.templateGenerator.step.HelmChartStep;

public class DeployWebStage extends Stage {
    public static final String SUFFIX = "web";

    public DeployWebStage(int port, boolean useDb) {
        this.name = "Deploy--Deploy app-webserver";
        WebAnswers ans = new WebAnswers(port);
        if (useDb) {
            ans.useDb();
        }
        this.steps.add(new HelmChartStep.Builder()
                .setChartName("web", SUFFIX)
                .setChartVersion(Constants.WEB_CHART_VERSION)
                .setWhen("master", "develop")
                .setAnswers(ans)
                .build());
    }
}
