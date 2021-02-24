package org.iiidevops.templateGenerator.stage;

import org.iiidevops.templateGenerator.step.Step;

import java.util.ArrayList;
import java.util.List;

abstract public class Stage {
    public String name;
    public List<Step> steps = new ArrayList<>();
}
