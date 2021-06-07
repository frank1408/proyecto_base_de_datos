# proyecto_base_de_datos
Se tiene instalado docker, jdk en mi sistema operativo GNU/Linux "Distro Debian 10"
Docker version 18.09.1, build 4c52b90
openjdk version "11.0.9.1" 2020-11-04
OpenJDK Runtime Environment (build 11.0.9.1+1-post-Debian-1deb10u2)
OpenJDK 64-Bit Server VM (build 11.0.9.1+1-post-Debian-1deb10u2, mixed mode, sharing)

Hay shellscript en este repo. El orden de ejecucion es:

# Se levanta la DB de SQL Server
./ferr

# Se construye la imagen y se levanta un contenedor
# para ejecutar una aplicacion grafica de Java que
# se compila y ejecuta dentro del contenedor
./build

# Una vez construido el contendor
# se pueden levantar varias instancias con
./appJava

La licencia GPL 3 aplica para el codigo en java y shellscripts.

El driver de conexion de microsoft
para SQL Server es necesario, para 
el proyecto, en este caso especifico,
porque tenia que ser con SQL Server.

En el sitio oficial se puede validar la licencia que usan para su driver.
https://docs.microsoft.com/en-us/sql/connect/jdbc/download-microsoft-jdbc-driver-for-sql-server?view=sql-server-ver15
