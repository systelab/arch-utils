package com.systelab.architecture.rules.classes;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.lang.reflect.Modifier;

public class ClassConditionUtilities {

    public static ArchCondition<JavaClass> hasAllFieldsPublic() {
        return new ArchCondition<JavaClass>("have all fields public") {
            @Override
            public void check(JavaClass item, ConditionEvents events) {
                if (!item.getAllFields().stream().allMatch(field -> Modifier.isPublic(field.reflect().getModifiers())))
                    events.add(SimpleConditionEvent.violated(item, "Class must have all fields public was not true for " + item.getName()));
            }
        };
    }

    public static ArchCondition<JavaClass> notHaveTheField(String fieldName) {
        return new ArchCondition<JavaClass>("not have a field named '" + fieldName + "'") {
            @Override
            public void check(JavaClass item, ConditionEvents events) {
                if (item.getAllFields().stream().anyMatch(field -> field.getFullName().contains(fieldName)))
                    events.add(SimpleConditionEvent.violated(item, "Must not have a field named '" + fieldName + "' was not true for "+item.getName()));
            }
        };
    }
}
