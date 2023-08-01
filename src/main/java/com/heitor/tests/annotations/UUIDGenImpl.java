package com.heitor.tests.annotations;

import java.lang.annotation.Annotation;
import java.util.UUID;

public class UUIDGenImpl implements UUIDGen {

    @Override
    public String key() {
        return UUID.randomUUID().toString();
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

}
