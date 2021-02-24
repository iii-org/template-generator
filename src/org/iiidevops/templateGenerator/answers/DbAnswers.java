package org.iiidevops.templateGenerator.answers;

public class DbAnswers extends GitAnswers {
    public DbAnswers(String dbType, String dbTag) {
        this.put("db.type", dbType);
        this.put("db.gui", true);
        this.put("db.username", "iiidevops");
        this.put("db.password", "templatePassword");
        this.put("db.name", "my_db");
        this.put("db.tag", dbTag);
    }
}
