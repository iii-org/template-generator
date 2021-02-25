package org.iiidevops.templateGenerator;

public class Target {
    private String name;
    private boolean buildImage = true;
    private boolean scanCheckmarx = true;
    private boolean deployDb = false;
    private DbArguments dbArguments;
    private boolean deployWeb = false;
    private WebArguments webArguments;
    private boolean testPostman = true;
    private boolean testWebinspect = true;

    public Target(String name) {
        this.name = name;
    }

    public WebArguments getWebArguments() {
        return webArguments;
    }

    public boolean isBuildImage() {
        return buildImage;
    }

    public boolean isScanCheckmarx() {
        return scanCheckmarx;
    }

    public boolean isTestPostman() {
        return testPostman;
    }

    public boolean isTestWebinspect() {
        return testWebinspect;
    }

    public boolean isDeployDb() {
        return deployDb;
    }

    public boolean isDeployWeb() { return deployWeb; }

    public String getName() {
        return name;
    }

    public DbArguments getDbArguments() {
        return dbArguments;
    }

    public static final class DbArguments {
        public DB_TYPE dbType;
        public String dbImageTag;

        public DbArguments(DB_TYPE dbType, String dbTag) {
            this.dbType = dbType;
            this.dbImageTag = dbTag;
        }

        public enum DB_TYPE {
            postgresql,
            mariadb,
            mongodb,
            mysql
        }
    }

    public static final class WebArguments {
        public int port;

        public WebArguments(int port) {
            this.port = port;
        }
    }

}
