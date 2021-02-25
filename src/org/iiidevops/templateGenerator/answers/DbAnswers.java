package org.iiidevops.templateGenerator.answers;

import org.iiidevops.templateGenerator.Constants;

public class DbAnswers extends GitAnswers {
    public DbAnswers(String dbType, String dbTag) {
        this.put("db.type", dbType);
        this.put("db.gui", true);
        this.put("db.username", Constants.DEFAULT_DB_USERNAME);
        this.put("db.password", Constants.DEFAULT_DB_PASSWORD);
        this.put("db.name", Constants.DEFAULT_DB_NAME);
        this.put("db.tag", dbTag);
    }
}
