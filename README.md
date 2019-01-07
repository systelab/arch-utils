
# arch-utils


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

### Run

To launch the server, simply run with java -jar the generated jar file.

```bash
cd target
java -jar arch-utils-1.0.jar
```


[git]: https://git-scm.com/
[maven]: https://maven.apache.org/download.cgi
[jdk-download]: http://www.oracle.com/technetwork/java/javase/downloads
[JEE]: http://www.oracle.com/technetwork/java/javaee/tech/index.html
[junit]: https://junit.org/junit5/


