package org.iiidevops.templateGenerator.stage;

import org.iiidevops.templateGenerator.Constants;
import org.iiidevops.templateGenerator.answers.DbAnswers;
import org.iiidevops.templateGenerator.step.HelmChartStep;

public class DeployDbStage extends Stage {
    public static final String SUFFIX = "db";

    public DeployDbStage(String dbType, String dbTag) {
        this.name = "Deploy--Deploy db";
        this.steps.add(new HelmChartStep.Builder()
                .setChartName("db", SUFFIX)
                .setChartVersion(Constants.DB_CHART_VERSION)
                .setWhen("master", "develop")
                .setAnswers(new DbAnswers(dbType, dbTag))
                .build());
    }
}
