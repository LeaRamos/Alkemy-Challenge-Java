# Alkemy-Challenge-Java

Es una ApiRest sobre el mundo de Disney , en el cual podremos ver personajes y las peliculas en el que estan involucrados. 


# Configuracion 

Se debe crear una Base de datos previamente con el de "alkemy". 
Configurar el usuario, contraseña y la base de datos creadas en el archivo "application.properties" ubicada en la ruta:"challenge-alkemy-master\src\main\resources\application.properties".

```
#Url donde esta el servicio de tu mysql y el nombre de la base de datos
spring.datasource.url=jdbc:mysql://localhost:3306/alkemy

#Usuario y contrasena para tu base de datos descrita en la linea anterior
spring.datasource.username="tu username"
spring.datasource.password="tu password"
```

# EndPoint

La aplicacion esta documentada detalladamente con Postman.
En la caperta "Postman" se encuentra el archivo "Alkemy challenge - Disney Word Movies.postman_collection.json" , el cual se podra ejecutar con la aplicacion Postman.
dicha carpeta se encuentra en la ruta: "challenge-alkemy-master\Postman\Alkemy challenge - Disney Word Movies.postman_collection.json".

# Primero pasos para ejecutar los Endpoint

## Autentificacion
El primer el Endpoint a ejecutar es el siguiente: http://localhost:8080/auth/signup con email y contraseña, para crear un usuario.
Lo siguiente es ejecutar el login con el siguiente Endpoint : http://localhost:8080/auth/signin con el email y contraseña utilizado en el registro.
Al loguearte, se obtendra un Token que se utilizara como autenticador y permitira usar los demas Endpoint.

# Creado por Leandro Ramos

