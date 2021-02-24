package org.iiidevops.templateGenerator;

import java.util.Map;

public class Target {
    private String folderName;
    private boolean buildImage = true;
    private boolean scanCheckmarx = true;
    private boolean deployDb = false;
    private DbArguments dbArguments;

    public Target(String folderName) {
        this.folderName = folderName;
    }

    public Target useBuildImage(boolean use) {
        this.buildImage = use;
        return this;
    }

    public Target useCheckmarx(boolean use) {
        this.scanCheckmarx = use;
        return this;
    }

    public Target enableDb(DB_TYPE dbType, String dbTag) {
        this.deployDb = true;
        this.dbArguments = new DbArguments(dbType, dbTag);
        return this;
    }

    public Target noDb() {
        this.deployDb = false;
        this.dbArguments = null;
        return this;
    }

    public boolean isBuildImage() {
        return buildImage;
    }

    public boolean isScanCheckmarx() {
        return scanCheckmarx;
    }

    public boolean isDeployDb() {
        return deployDb;
    }

    public String getFolderName() {
        return folderName;
    }

    public DbArguments getDbArguments() {
        return dbArguments;
    }

    public static final class DbArguments {
        public DB_TYPE dbType;
        public String dbTag;

        public DbArguments(DB_TYPE dbType, String dbTag) {
            this.dbType = dbType;
            this.dbTag = dbTag;
        }
    }

    public enum DB_TYPE {
        postgresql,
        mariadb,
        mongodb,
        mysql
    }
}
