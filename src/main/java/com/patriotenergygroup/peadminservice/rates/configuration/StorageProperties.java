package com.patriotenergygroup.peadminservice.rates.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "application.storage")
public class StorageProperties {

    //Change to something that can be retrieved from a configuration file.
    private String location = "D://temp//";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}