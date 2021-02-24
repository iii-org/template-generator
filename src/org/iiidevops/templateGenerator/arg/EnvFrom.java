package org.iiidevops.templateGenerator.arg;

import java.util.ArrayList;
import java.util.TreeMap;

public class EnvFrom extends ArrayList<TreeMap<String, Object>> {
    public boolean addEnv(String sourceName, String sourceKey, String targetKey) {
        TreeMap<String, Object> map = new TreeMap<>();
        map.put("sourceName", sourceName);
        map.put("sourceKey", sourceKey);
        map.put("targetKey", targetKey);
        return this.add(map);
    }
}
