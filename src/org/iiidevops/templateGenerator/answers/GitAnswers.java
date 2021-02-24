package org.iiidevops.templateGenerator.answers;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.TreeMap;

public class GitAnswers extends TreeMap<String, Object> implements Answers {
    public GitAnswers() {
        this.put("git.url", "${CICD_GIT_URL}");
        this.put("git.repoName", "${CICD_GIT_REPO_NAME}");
        this.put("git.branch", "${CICD_GIT_BRANCH}");
        this.put("git.commitID", "${CICD_GIT_COMMIT}");
    }
}
