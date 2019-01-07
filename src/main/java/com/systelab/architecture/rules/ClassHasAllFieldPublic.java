package com.systelab.architecture.rules;

import com.tngtech.archunit.core.domain.JavaClass;
import com.tngtech.archunit.lang.ArchCondition;
import com.tngtech.archunit.lang.ConditionEvents;
import com.tngtech.archunit.lang.SimpleConditionEvent;

import java.lang.reflect.Modifier;

public class ClassHasAllFieldPublic extends ArchCondition<JavaClass> {

    public ClassHasAllFieldPublic() {
        super("have all fields public");
    }

    @Override
    public void check(JavaClass item, ConditionEvents events) {
        if (!item.getAllFields().stream().allMatch(field -> Modifier.isPublic(field.reflect().getModifiers())))
            events.add(SimpleConditionEvent.violated(item, "Class must have all fields public was not true for "+item.getName()));
    }
}