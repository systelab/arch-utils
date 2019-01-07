package com.systelab.architecture.rules;

import com.tngtech.archunit.base.DescribedPredicate;
import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.domain.JavaMember;
import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.core.domain.properties.HasModifiers;
import com.tngtech.archunit.core.domain.properties.HasOwner;
import com.tngtech.archunit.lang.*;

import java.util.ArrayList;
import java.util.List;

import static com.tngtech.archunit.core.domain.Formatters.formatLocation;
import static com.tngtech.archunit.core.domain.JavaModifier.PUBLIC;
import static com.tngtech.archunit.core.domain.properties.CanBeAnnotated.Predicates.annotatedWith;
import static com.tngtech.archunit.core.domain.properties.HasModifiers.Predicates.modifier;

public class MethodUtilities {
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

    public static DescribedPredicate<? super JavaMember> inClassesAnnotatedWith(final Class className) {
        return HasOwner.Functions.Get.<JavaClass>owner().is(annotatedWith(className));
    }

    public static DescribedPredicate<HasModifiers> arePublic() {
        return modifier(PUBLIC).as("are public");
    }

    public static ArchCondition<JavaMethod> beAnnotated(final Class<?> type) {
        return new ArchCondition<JavaMethod>("are annotated by type " + type.getSimpleName()) {
            @Override
            public void check(JavaMethod method, ConditionEvents events) {
                boolean annotationMatches = method.isAnnotatedWith(type.getName());
                String message = String.format("%s in %s is not annotated with %s",
                        method.getFullName(), formatLocation(method.getOwner(), 0), type.getSimpleName());
                events.add(new SimpleConditionEvent(method, annotationMatches, message));
            }
        };
    }

    public static ArchCondition<JavaMethod> returnType(final Class<?> type) {
        return new ArchCondition<JavaMethod>("return type " + type.getName()) {
            @Override
            public void check(JavaMethod method, ConditionEvents events) {
                boolean typeMatches = method.getReturnType().isAssignableTo(type);
                String message = String.format("%s returns %s in %s",
                        method.getFullName(), method.getReturnType().getName(),
                        formatLocation(method.getOwner(), 0));
                events.add(new SimpleConditionEvent(method, typeMatches, message));
            }
        };
    }
}
