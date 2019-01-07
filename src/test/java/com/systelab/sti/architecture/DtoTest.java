package com.systelab.sti.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.systelab.architecture.rules.classes.ClassConditionUtilities.hasAllFieldsPublic;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "com.systelab")
public class DtoTest {


    @ArchTest
    static ArchRule dtoClassesShouldHaveAllFieldsPublic = classes()
            .that().areAnnotatedWith(Deprecated.class)
            .should(hasAllFieldsPublic())
            .because("Dto classes should have all fields as public as we do not want any kind of logic inside");
}