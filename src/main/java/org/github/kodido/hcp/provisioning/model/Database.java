package org.github.kodido.hcp.provisioning.model;

/**
 * Created by i031908 on 21/10/16.
 */
public class Database {

    private String type;
    private String version;
    private String name;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return new StringBuffer(name).append("(").append(type).append("):").append(version).toString();
    }

}
