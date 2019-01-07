package com.systelab.architecture.rules;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaField;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.lang.AbstractClassesTransformer;
import com.tngtech.archunit.lang.ClassesTransformer;

import java.util.ArrayList;
import java.util.List;

public class ClassTransformers {
    public static ClassesTransformer<JavaMethod> methods() {
        return new AbstractClassesTransformer<JavaMethod>("methods") {
            @Override
            public Iterable<JavaMethod> doTransform(JavaClasses javaClasses) {
                List<JavaMethod> methods = new ArrayList<>();
                for (JavaClass javaClass : javaClasses) {
                    methods.addAll(javaClass.getMethods());
                }
                return methods;
            }
        };
    }

    public static ClassesTransformer<JavaField> fields() {
        return new AbstractClassesTransformer<JavaField>("fields") {
            @Override
            public Iterable<JavaField> doTransform(JavaClasses javaClasses) {
                List<JavaField> fields = new ArrayList<>();
                for (JavaClass javaClass : javaClasses) {
                    fields.addAll(javaClass.getAllFields());
                }
                return fields;
            }
        };
    }
}
