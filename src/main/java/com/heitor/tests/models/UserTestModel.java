package com.heitor.tests.models;

import com.heitor.tests.annotations.UUIDGen;
import com.heitor.tests.utils.Logger;

public class UserTestModel {
    private String name;

    private String uuid;

    public void teste(@UUIDGen String uuid) {
        Logger.alert("test valor do attribute => " + uuid);
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "UserTestModel{" +
                "name='" + name + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}
