package com.heitor.tests.models;

import com.heitor.tests.annotations.UUIDGen;
import com.heitor.tests.utils.Logger;

public class UserModel {
    private String name;

    private String uuid;

    public void setUuid(@UUIDGen(key = "test key passando no metodo") String uuid) {
        Logger.alert("test valor do attribute => " + uuid);
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
