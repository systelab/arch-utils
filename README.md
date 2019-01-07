
# ArchUnit utilities

This is a Java libraries with some utilities (mainly transformers, predicates and conditions) to empower your [ArchUnit test][archunit]. 
ArchUnit is a free, simple and extensible library for checking the architecture of a Java code.

> This library depends on [JUnit 5][junit]. If you are using the previous version, please upgrade.  

In general, a rule is applied to JavaClasses that can be transformed to custom objects, and then filtered by predicates and checked against given conditions.

![Image](https://www.archunit.org/userguide/html/import-vs-lang.png "Logo Title Text 1")

## Getting Started

To get you started you can simply clone the `arch-utils` repository and install the dependencies.

### Prerequisites

You need [git][git] to clone the `arch-utils` repository.

You will need [Java™ SE Development Kit 8][jdk-download] and [Maven][maven].

### Clone

Clone the `arch-utils` repository using git:

```bash
git clone https://github.com/systelab/arch-utils.git
cd arch-utils
```

### Install Dependencies

In order to install the dependencies, you must run:

```bash
mvn clean install
```

## Release

In order to release a new version:

Step 1. Update the version in your pom.xml file. For example:

```
<version>1.0.2</version>
```

Step 2. Commit and push in the master branch, and generate a new Release by pressing the button "Draft new release".

In the example use v.1.0.2 as the Tag version, and 1.0.2 as the release title.

Step 3. Head to https://jitpack.io and look up "systelab/arch-utils". Choose the new version and press the button "Get it". Check the log to verify that everything is fine.


## Using the library

In order to use the library, you should add the dependency to your project.

### Gradle

In order to use the library, you should:

Add it in your root build.gradle at the end of repositories:

```
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add the dependency

```
dependencies {
    implementation 'com.github.systelab:arch-utils:v1.0.2'
}
```

### Maven

Step 1. Add the JitPack repository to your build file

```
	<repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
```

Step 2. Add the dependency

```
	<dependency>
	    <groupId>com.github.systelab</groupId>
	    <artifactId>arch-utils</artifactId>
	    <version>v1.0.2</version>
	</dependency>
```

## Custom Objects

ClassesTransformer define how JavaClasses are to be transformed to the desired rule input.
The following transformers are provided:

- constructors()
- fields()
- methods() 

For example:

```
@ArchTest
static ArchRule allPublicMethodsInRestControllersShouldReturnResponseEntity =
	all(methods())
        	.that(inClassesAnnotatedWith(MyAnnotation.class)).and(arePublic())
                .should(returnType(String.class))
                .because("we want to have String in methods of classes annotated with @MyAnnotation");
```


[git]: https://git-scm.com/
[archunit]: https://git-scm.com/
[maven]: https://maven.apache.org/download.cgi
[jdk-download]: http://www.oracle.com/technetwork/java/javase/downloads
[JEE]: http://www.oracle.com/technetwork/java/javaee/tech/index.html
[junit]: https://junit.org/junit5/


