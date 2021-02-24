package org.iiidevops.templateGenerator.arg;

import java.util.ArrayList;
import java.util.List;

public class When {
    public Branch branch = new Branch();

    public When(String... branches) {
        this.branch.include = List.of(branches);
    }

    static class Branch {
        public List<String> include = new ArrayList<>();
    }
}
