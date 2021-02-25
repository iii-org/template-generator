package org.iiidevops.templateGenerator.stage;

import org.iiidevops.templateGenerator.Constants;
import org.iiidevops.templateGenerator.answers.PipeSeqAnswers;
import org.iiidevops.templateGenerator.answers.TestPostmanAnswers;
import org.iiidevops.templateGenerator.step.HelmChartStep;

public class TestPostmanStage extends Stage {
    public TestPostmanStage(int port) {
        this.name = "Postman test";
        this.steps.add(new HelmChartStep.Builder()
                .setChartName("test-postman", "pm")
                .setChartVersion(Constants.TEST_POSTMAN_CHART_VERSION)
                .setWhen("master")
                .setAnswers(new TestPostmanAnswers(port))
                .build()
        );
    }
}
