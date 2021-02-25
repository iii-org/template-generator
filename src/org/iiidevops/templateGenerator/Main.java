package org.iiidevops.templateGenerator;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());

        JsonReader reader = new JsonReader(new FileReader("templates.json"));
        List<Target> templates = gson.fromJson(reader, new TypeToken<List<Target>>() {
        }.getType());

        String rootDir = System.getenv().get("template_root");
        templates.forEach(target -> {
            try {
                Root root = new Root(target);
                String folder = "";
                if (rootDir != null) {
                    folder += rootDir + "/";
                }
                folder += target.getFolderName();
                mapper.writeValue(new File(folder + "/.rancher-pipeline.yml"),
                        root);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.printf("%s written.%n", target.getFolderName());
        });
        System.out.println("Job done.");
    }

}
