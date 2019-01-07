
# arch-utils

This is a Java libraries with some utilities (mainly transformers, predicates and conditions) to empower your [ArchUnit test][archunit].

In general, a rule 
```
classes that ${PREDICATE} should ${CONDITION}
```

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

In order to install the dependencies and generate the Uber jar you must run:

```bash
mvn clean install
```

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

[git]: https://git-scm.com/
[archunit]: https://git-scm.com/
[maven]: https://maven.apache.org/download.cgi
[jdk-download]: http://www.oracle.com/technetwork/java/javase/downloads
[JEE]: http://www.oracle.com/technetwork/java/javaee/tech/index.html
[junit]: https://junit.org/junit5/


