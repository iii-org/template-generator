package org.iiidevops.templateGenerator.stage;

import org.iiidevops.templateGenerator.answers.DbAnswers;
import org.iiidevops.templateGenerator.arg.When;
import org.iiidevops.templateGenerator.step.HelmChartStep;

import java.util.List;

public class DeployDbStage extends Stage {
    public DeployDbStage(String dbType, String dbTag) {
        this.name = "Deploy db";
        this.steps.add(new HelmChartStep.Builder()
                .setChartName("db", "db")
                .setChartVersion("0.3.0")
                .setWhen(List.of("master"))
                .setAnswers(new DbAnswers(dbType, dbTag))
                .build());
    }
}
