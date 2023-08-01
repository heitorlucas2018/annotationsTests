package com.heitor.tests;

import com.heitor.tests.annotations.Implements;
import com.heitor.tests.annotations.UUIDGen;
import com.heitor.tests.utils.Logger;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public final class MainReflectedApplication {
    private MainReflectedApplication(){}

    static Optional<Object> loadImplAnnotation(final Class classAnnotation) throws Exception {
        Validate.isAnnotatedImplements(classAnnotation);

        final var implementation = ((Implements) classAnnotation.getAnnotation(Implements.class)).value();
        final var isValidClass = Validate.implemetations(classAnnotation, implementation);
    
        if(isValidClass) {

            Logger.info(classAnnotation," implemented in [", implementation.getCanonicalName() );

            final var instance = implementation.getConstructor().newInstance();
            for (Method method: classAnnotation.getMethods()) {
                return Optional.of(method.invoke(instance));
            }
        }
        

        return Optional.empty();
    }

    public static <T extends Object> T autoLoadAndExecuteAnnotations(Class<T> pClass) throws Exception {
        final var clazz = Class.forName(pClass.getCanonicalName());
        final var instance = clazz.getDeclaredConstructor().newInstance();
        Logger.info("Autoload class => " + clazz);

        for(Method method: clazz.getMethods()) {
            for(Parameter param: method.getParameters()) {
                if(param.isAnnotationPresent(UUIDGen.class)) {
                    var value = Objects.requireNonNull(param.getAnnotation(UUIDGen.class)).key();
                    if(value.equals("")) {
                        value = (String) loadImplAnnotation(UUIDGen.class).get();
                    }

                    method.invoke(instance, value);
                }
            }
        }

        return (T) instance;
    }

    protected static final class Validate {
        private static void isAnnotatedImplements(Class classAnnotation) throws Exception {
            if(!classAnnotation.isAnnotation()) {
                throw new Exception("Not's class annotation, please verify " + classAnnotation.getCanonicalName());
            }

            if(!classAnnotation.isAnnotationPresent(Implements.class)){
                throw new Exception("Not's implemented annotation, please verify " + classAnnotation.getCanonicalName());
            }
        }

        private static boolean implemetations(Class classAnnotation, Class implementation) throws Exception {
            return Arrays.asList(implementation.getInterfaces()).contains(classAnnotation);
        }
    }
}
