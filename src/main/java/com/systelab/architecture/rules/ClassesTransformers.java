package com.systelab.architecture.rules;

import com.tngtech.archunit.core.domain.*;
import com.tngtech.archunit.lang.AbstractClassesTransformer;
import com.tngtech.archunit.lang.ClassesTransformer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ClassesTransformers {

    public static Stream<JavaClass> getStream(JavaClasses javaClasses) {
        Iterable<JavaClass> iterable = () -> javaClasses.iterator();
        return  StreamSupport.stream(iterable.spliterator(), false);
    }

    public static ClassesTransformer<JavaConstructor> constructors() {
        return new AbstractClassesTransformer<JavaConstructor>("constructors") {
            @Override
            public Iterable<JavaConstructor> doTransform(JavaClasses javaClasses) {
                List<JavaConstructor> constructors = new ArrayList<>();
                getStream(javaClasses).forEach(javaClass -> constructors.addAll(javaClass.getAllConstructors()));
                return constructors;
            }
        };
    }

    public static ClassesTransformer<JavaMethod> methods() {
        return new AbstractClassesTransformer<JavaMethod>("methods") {
            @Override
            public Iterable<JavaMethod> doTransform(JavaClasses javaClasses) {
                List<JavaMethod> methods = new ArrayList<>();
                getStream(javaClasses).forEach(javaClass -> methods.addAll(javaClass.getMethods()));
                return methods;
            }
        };
    }

    public static ClassesTransformer<JavaField> fields() {
        return new AbstractClassesTransformer<JavaField>("fields") {
            @Override
            public Iterable<JavaField> doTransform(JavaClasses javaClasses) {
                List<JavaField> fields = new ArrayList<>();
                getStream(javaClasses).forEach(javaClass -> fields.addAll(javaClass.getAllFields()));
                return fields;
            }
        };
    }
}
