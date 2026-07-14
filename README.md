# Escáner de Red y Gestión de Recursos por Aula

## Descripción

Este proyecto fue desarrollado en Java como parte de la asignatura de Redes y Bases de Datos.

La aplicación permite escanear una red local, detectar los equipos activos mediante ping, obtener su dirección MAC y almacenar la información en una base de datos MariaDB utilizando JDBC.

---

## Objetivos

- Escanear una red local.
- Detectar equipos activos.
- Obtener la dirección IP y la dirección MAC.
- Almacenar la información en una base de datos relacional.
- Aplicar conceptos de Programación Orientada a Objetos.
- Integrar Java, Redes y Bases de Datos.

---

## Tecnologías utilizadas

- Java
- JDBC
- MariaDB
- Git
- GitHub
- Fedora Linux

---

## Estructura del proyecto

```
redesv2/
│
├── database/
│   └── escaner_red.sql
│
├── src/
│   ├── Main.java
│   ├── EscanerRed.java
│   ├── Equipo.java
│   └── BaseDatos.java
│
├── README.md
└── .gitignore
```

---

## Funcionamiento

1. El usuario ingresa la red a escanear.

Ejemplo:

```
192.168.1
```

2. El programa recorre un rango de direcciones IP.

Ejemplo:

```
192.168.1.1
192.168.1.2
...
192.168.1.20
```

3. Se verifica si cada dirección responde mediante `InetAddress.isReachable()`.

4. Si el equipo está activo, se obtiene la dirección MAC utilizando el comando `ip neigh`.

5. Se crea un objeto `Equipo`.

6. El objeto se almacena en un `ArrayList`.

7. La información también se guarda en MariaDB utilizando JDBC.

8. Finalmente se muestran los equipos encontrados.

---

## Base de datos

Tabla:

```
equipos
```

Campos:

- id
- ip
- mac
- activo

La dirección IP posee una restricción **UNIQUE**, evitando registros duplicados.

---

## Requisitos

- Java instalado.
- MariaDB instalado.
- Driver JDBC de MariaDB.
- Base de datos creada utilizando el archivo:

```
database/escaner_red.sql
```

---

## Compilación

```bash
javac -cp /usr/lib/java/mariadb-java-client.jar:. src/*.java
```

---

## Ejecución

```bash
java -cp /usr/lib/java/mariadb-java-client.jar:src Main
```

---

## Autor

Facundo Duarte
Bryan Chialvo
Joaquin Castro