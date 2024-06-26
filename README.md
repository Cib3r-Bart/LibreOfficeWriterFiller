# RESUMEN/RESUME
Esta es una simple aplicación de JavaFX que sirve como ejemplo de como cumplimentar documentos en LibreOffice WRITER a través de una aplicación de Java.
This is a simple JavaFX application that serves as an example of how to fill documents in LibreOffice WRITER through a Java application.

# ESTRUCTURA/STRUCTURE
La aplicación ha sido creada con OpenJDK7, JavaFX17 y usa las librerías simple-odf y odfdom-java. Siguiendo las buenas prácticas de programación en JavaFX 
se ha creado un servicio heredando de la clase Service de JavaFX que evita que se bloquee la interfaz y permite asociar elementos que muestran el progreso
del servicio, como una progressBar.
The application has been created with OpenJDK7, JavaFX17 and uses the simple-odf and odfdom-java libraries. Following the good practices of programming in JavaFX 
a service has been created inheriting from the JavaFX Service class that prevents the interface from blocking and allows to associate elements that show the progress of the service, such as a progressBar.
of the service, such as a progressBar.

# PASOS PARA ADAPTARLO A TU PROYECTO/STEPS TO USE IN YOUR PROYECT
