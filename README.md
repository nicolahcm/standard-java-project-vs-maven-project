# General Description:
    We have a simple project that connects to the db with JDBC (MySQL).
    The only dependencies are JDBC driver for MySQL and the log4j for logging.

In the project built with plain java we can note that
    - The depndencies are java file put in the folder "lib"
    - In order to include them as dependencies, if we run through:
        1. IDE eclipse, Project > Properties > Java Build Path > Add Jars > Select the dependencies
        2. command line, add the dependencies and the main application as jar in the -cp (classpath)
            argument, which is a VM (Java) argument. Then indicate the path of the Main file of exec.
            (i.e. it.generali.app.Main). See The file avvio.bat, which contains the code for executing.

            2.a) For creating a jar file of the Main application, right click (in eclipse) on the file
            then > export > (typically we select in the "dist" folder)
            2.b) We have VM arguments, Program Arguments (and maybe also environment arguments). In the 
            command line, VM arguments are put before the path of the program (it.gener.app.main), while
            the program arguments are put after. The firsts can be accessed through System.getProperty.
            While the others are accessed through main(String[] args)

The Project built with maven has a pom.xml. Compare the dependencies. 
    - It will produce a jar file in the target folder.
    - Run with "java -jar -DappProperties="..." target\file.jar"

Other small notes:
    - The pom.xml, in <build> </build>, also needs to specify where the main class is
    - If we want to build the maven project with Eclipse:
        Add in goals "clean package"
        