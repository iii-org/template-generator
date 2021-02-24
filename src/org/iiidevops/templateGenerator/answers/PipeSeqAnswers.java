package org.iiidevops.templateGenerator.answers;

public class PipeSeqAnswers extends GitAnswers {
    public PipeSeqAnswers() {
        this.put("pipeline.sequence", "${CICD_EXECUTION_SEQUENCE}");
    }
}
