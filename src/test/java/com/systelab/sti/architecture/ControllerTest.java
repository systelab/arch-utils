package com.systelab.sti.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.systelab.architecture.rules.ClassTransformers.methods;
import static com.systelab.architecture.rules.methods.MethodConditionUtilities.*;
import static com.systelab.architecture.rules.methods.MethodPredicateUtilities.arePublic;
import static com.systelab.architecture.rules.methods.MethodPredicateUtilities.inClassesAnnotatedWith;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;

@AnalyzeClasses(packages = "com.systelab.sti")
public class ControllerTest {

    @ArchTest
    static ArchRule allFilesInPackageControllerShouldBeControllersOrDtos = classes()
            .that().resideInAPackage("..controller..")
            .should().haveSimpleNameEndingWith("Controller").orShould().haveSimpleNameEndingWith("Dto")
            .because("we want to have only controllers and dtos in the controllers folder");

    @ArchTest
    static ArchRule allPublicMethodsInRestControllersShouldReturnResponseEntity =
            all(methods())
                    .that(inClassesAnnotatedWith(Deprecated.class)).and(arePublic())
                    .should(returnType(String.class))
                    .because("we don't want to couple the client code directly to the return types of the encapsulated module");

    @ArchTest
    static ArchRule controllersShouldNotAccessRepositories = noClasses()
            .that().resideInAPackage("..controller..")
            .should().accessClassesThat().resideInAPackage("..repository..")
            .because("we want controller classes to do not access repository classes directly");
}