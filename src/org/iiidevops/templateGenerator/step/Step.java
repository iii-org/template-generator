package org.iiidevops.templateGenerator.step;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.iiidevops.templateGenerator.arg.When;

@JsonPropertyOrder(alphabetic=true)
public class Step {
    public When when;
}
