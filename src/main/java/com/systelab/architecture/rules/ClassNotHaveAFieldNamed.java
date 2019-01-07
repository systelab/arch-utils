package com.systelab.architecture.rules;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

public class ClassNotHaveAFieldNamed extends ArchCondition<JavaClass> {

    private String fieldName;

    public ClassNotHaveAFieldNamed(String fieldName) {
        super("not have a field named '" + fieldName + "'");
        this.fieldName = fieldName;
    }

    @Override
    public void check(JavaClass item, ConditionEvents events) {
        if (item.getAllFields().stream().anyMatch(field -> field.getFullName().contains(fieldName)))
            events.add(SimpleConditionEvent.violated(item, "Must not have a field named '" + fieldName + "' was not true for "+item.getName()));
    }
}
