package com.heitor.tests;

import static com.heitor.tests.MainReflectedApplication.autoLoadAndExecuteAnnotations;

import com.heitor.tests.models.UserModel;
import com.heitor.tests.models.UserTestModel;
import com.heitor.tests.utils.Logger;


public class Main {


    public static void main(String[] args) throws Exception {
        Logger.info("Main Application Test ", autoLoadAndExecuteAnnotations(UserModel.class));
        Logger.info("Test sem informar valor ", autoLoadAndExecuteAnnotations(UserTestModel.class));
    }
}