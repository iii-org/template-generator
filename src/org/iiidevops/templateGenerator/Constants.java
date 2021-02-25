package org.iiidevops.templateGenerator;

public class Constants {

    public static final String HARBOR_HOST = "harbor-demo.iiidevops.org";
    public static final String BUILD_IMAGE_TAG = "${CICD_GIT_REPO_NAME}/${CICD_GIT_BRANCH}:latest";
    public static final String WEB_CHART_VERSION = "0.5.0";

    public static final String DB_CHART_VERSION = "0.3.0";
    public static final String DEFAULT_DB_USERNAME = "iiidevops";
    public static final String DEFAULT_DB_PASSWORD = "templatePassword";
    public static final String DEFAULT_DB_NAME = "my_db";

    public static final String SCAN_CHECKMARX_CHART_VERSION = "0.1.0";
    public static final String TEST_POSTMAN_CHART_VERSION = "0.1.0";
    public static final String TEST_WEBINSPECT_CHART_VERSION = "0.1.0";

    public static final String DEPLOYMENT_WAITER_VERSION = "0.0.2";
}
