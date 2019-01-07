package com.systelab.architecture.rules.examples;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.systelab.architecture.rules.classes.ClassConditionUtilities.haveAllFieldsPublic;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.systelab")
public class DtoTest {

    @ArchTest
    static ArchRule dtoClassesShouldHaveAllFieldsPublic = classes()
            .that().areAnnotatedWith(Deprecated.class)
            .should(haveAllFieldsPublic())
            .because("Dto classes should have all fields as public as we do not want any kind of logic inside");
}