package org.iiidevops.templateGenerator.step;

import org.iiidevops.templateGenerator.answers.Answers;
import org.iiidevops.templateGenerator.answers.GitAnswers;
import org.iiidevops.templateGenerator.arg.When;

import java.util.List;

public class HelmChartStep extends Step {
    public ApplyAppConfig applyAppConfig;

    HelmChartStep(Builder builder) {
        this.applyAppConfig = new ApplyAppConfig(builder);
        this.when = builder.when;
    }

    public static class Builder {
        String chartName;
        String chartVersion;
        String shortName;
        When when;
        Answers answers;

        public Builder setChartName(String chartName, String shortName) {
            this.chartName = chartName;
            this.shortName = shortName;
            return this;
        }

        public Builder setChartVersion(String chartVersion) {
            this.chartVersion = chartVersion;
            return this;
        }

        public Builder setWhen(List<String> branches) {
            this.when = new When(branches);
            return this;
        }

        public Builder setAnswers(GitAnswers answers) {
            this.answers = answers;
            return this;
        }

        public HelmChartStep build() {
            return new HelmChartStep(this);
        }
    }

    static class ApplyAppConfig {
        public String catalogTemplate;
        public String version;
        public String name;
        public String targetNamespace;
        public Answers answers;

        public ApplyAppConfig(Builder builder) {
            this.catalogTemplate = "cattle-global-data:iii-dev-charts3-" + builder.chartName;
            this.version = builder.chartVersion;
            this.name = "${CICD_GIT_REPO_NAME}-${CICD_GIT_BRANCH}-" + builder.shortName;
            this.targetNamespace = "${CICD_GIT_REPO_NAME}";
            this.answers = builder.answers;
        }
    }
}
