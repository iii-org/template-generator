package org.iiidevops.templateGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        TEMPLATES.forEach(target -> {
            Root root = new Root(target);
            try {
                // TODO: Change to real path
                mapper.writeValue(new File(".rancher-pipeline.yaml"), root);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.printf("%s written.%n", target.getFolderName());
        });
        System.out.println("Job done.");
    }

    private static final List<Target> TEMPLATES = List.of(
            new Target("django-postgresql-todo")
                    .enableDb(Target.DB_TYPE.postgresql, "13.2.0")
    );

}
