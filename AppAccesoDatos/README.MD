Práctica 1. Vamos a poner en práctica lo visto hasta el momento trabajando sobre el fichero alumnos.xml).

Recordad que el puerto del servidor puede variar en base a lo que tengáis indicado en el fichero application.properties. Por defecto se usa el 8080.

Ejercicio 1. (http:localhost:8080/)
	- Cargad los alumnos del fichero alumnos.xml para mostrarse en la página principal mediante DOM. Lo único que deberéis completar es el metodo createDemoListDom dentro de GeneralService.java
	
Ejercicio 2. (http:localhost:8080/indexSax)
	- Cargad los alumnos del fichero alumnos.xml para mostrarse en la página principal mediante SAX. Lo único que deberéis completar es el metodo createDemoListSax dentro de GeneralService.java
	
Ejercicio 3. (http:localhost:8080/indexJaxb)
	- Cargad los alumnos del fichero alumnos.xml para mostrarse en la página principal mediante Jaxb. Lo único que deberéis completar es el metodo createDemoListJaxb dentro de GeneralService.java
	
Ejercicio 4. (Pulsando sobre la lupa de cualquier alumno en cualquier ventana)
	- Cargad el detalle del alumno seleccionado. Podéis hacerlo mediante SAX O Jaxb, nunca mediante DOM. Lo único que deberéis completar es el metodo getDataAlumn dentro de GeneralService.java
	
Ejercicio 5. (Pulsando sobre Nuevo Alumno en cualquiera de los listados)
	- Cread un nuevo alumno. Deberéis hacerlo mediante JAXB. Lo único que deberéis completar es el metodo createAlumn dentro de GeneralService.java.