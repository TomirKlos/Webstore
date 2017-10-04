package com.klaster.webstore.domain;
import java.io.Serializable;
/**
 * Created by MSI DRAGON on 2017-10-02.
 */


public enum UserProfileType implements Serializable{
    USER("USER"),
    DBA("DBA"),
    ADMIN("ADMIN");

    String userProfileType;

    private UserProfileType(String userProfileType){
        this.userProfileType = userProfileType;
    }

    public String getUserProfileType(){
        return userProfileType;
    }

}
