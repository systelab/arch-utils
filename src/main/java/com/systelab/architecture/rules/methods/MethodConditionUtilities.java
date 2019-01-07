package com.systelab.architecture.rules.methods;

import com.tngtech.archunit.core.domain.JavaMethod;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import static com.tngtech.archunit.core.domain.Formatters.formatLocation;

public class MethodConditionUtilities {

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
