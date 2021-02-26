package org.iiidevops.templateGenerator.stage;

import org.iiidevops.templateGenerator.Constants;
import org.iiidevops.templateGenerator.answers.TestPostmanAnswers;
import org.iiidevops.templateGenerator.answers.TestWebinspectAnswers;
import org.iiidevops.templateGenerator.step.HelmChartStep;

public class TestWebinspectStage extends Stage {
    public TestWebinspectStage() {
        this.name = "Test--Webinspect test";
        this.steps.add(new HelmChartStep.Builder()
                .setChartName("test-webinspect", "wi")
                .setChartVersion(Constants.TEST_WEBINSPECT_CHART_VERSION)
                .setWhen("master")
                .setAnswers(new TestWebinspectAnswers())
                .build()
        );
    }
}
