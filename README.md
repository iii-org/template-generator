# template-generator
A Java tool to batch generate and update `.rancher-pipeline.yml` of templates.

# Usage
Place the `templateYAMLGenerator.jar` and `templates.json` into the root directory of your templates, then:

`$ java -jar templateYAMLGenerator.jar`

This will replace all `.rancher-pipeline.yml` files in all directories you describe in `templates.json`.
