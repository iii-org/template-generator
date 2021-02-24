package org.iiidevops.templateGenerator.stage;

import org.iiidevops.templateGenerator.answers.PipeSeqAnswers;
import org.iiidevops.templateGenerator.arg.When;
import org.iiidevops.templateGenerator.step.HelmChartStep;

import java.util.List;

public class ScanCheckmarxStage extends Stage {
    public ScanCheckmarxStage() {
        this.name = "Checkmarx source code scan";
        this.steps.add(new HelmChartStep.Builder()
                .setChartName("scan-checkmarx", "cmx")
                .setChartVersion("0.1.0")
                .setWhen(List.of("master", "checkmarx"))
                .setAnswers(new PipeSeqAnswers())
                .build()
        );
    }
}
