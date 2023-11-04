# 📘 Conexión Java - Oracle Cloud

## 🚀 Descripción del Proyecto: Simulador de Gestión de Biblioteca

Este es un proyecto educativo construido con Java 11, que simula un sistema de gestión de biblioteca con operaciones CRUD básicas, interactuando con una base de datos Oracle Cloud. Diseñado para enseñar a los estudiantes sobre la interacción entre Java y las bases de datos Oracle usando JDBC.

## 📋 Índice
- [Pre-requisitos](#pre-requisitos)
- [Configuración y Ejecución](#configuración-y-ejecución)
- [Características del Sistema](#características-del-sistema)
- [Seguridad](#seguridad)
- [Contribución](#contribución)

## 🛠 Pre-requisitos

1. **Java JDK 11**: Asegúrate de tenerlo instalado y configurado.
2. **Oracle Cloud Wallet**: Necesario para la configuración de JDBC.
3. **ojdbc11**: Biblioteca requerida para la conexión con Oracle Database.
4. **oraclepki.jar**: Biblioteca requerida para corregir error de fata de ´key store´.
5. Estos drivers los puedes obtener de [JDBC and UCP Download page](https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html)

## ▶️ Configuración y Ejecución

### Configuración de Oracle Wallet
1. Descarga tu wallet de Oracle Cloud.
2. Colócalo en una ubicación segura en tu máquina.
3. Configura el path del wallet en la clase `ConexionBD`.
4. Configura `URL`, `USER` y `PASSWORD` en la clase `ConexionBD`.
```java
package com.oracledbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.nio.file.Paths;
import java.util.Properties;

public class Conexion{

    private static final String WALLET_PATH = "RUTA DE DONDE ESTÁ LA WALLET. NO DEBE SER UN ZIP";
    private static final String WALLET_PASSWORD = "CONTRASEÑA";
    private static final String JDBC_URL = "jdbc:oracle:thin:@testdb_high - REEMPLAZA 'testdb_high' EN EL ARCHIVO TNSNAMES.ORA APARECE AL INICIO [NOMBRE DE LA DB]_HIGH";

    public static Connection obtenerConexion() throws Exception {
        // Configuración del wallet
        String trustStorePath = Paths.get(WALLET_PATH, "truststore.jks").toString();
        String keyStorePath = Paths.get(WALLET_PATH, "keystore.jks").toString();

        System.setProperty("oracle.net.tns_admin", WALLET_PATH);
        System.setProperty("javax.net.ssl.trustStore", trustStorePath);
        System.setProperty("javax.net.ssl.trustStorePassword", WALLET_PASSWORD);
        System.setProperty("javax.net.ssl.keyStore", keyStorePath);
        System.setProperty("javax.net.ssl.keyStorePassword", WALLET_PASSWORD);

        Properties properties = new Properties();
        properties.put("user", "admin");
        properties.put("password", WALLET_PASSWORD);

        return DriverManager.getConnection(JDBC_URL, properties);
    }
}
```
### 📚 Configuración de ojdbc11
Asegúrate que `ojdbc11.jar` está en tu classpath o en el directorio `lib` de tu proyecto.

## 💻 Características del Sistema

- **Ver Libros**: Mostrar todos los libros en la biblioteca.
- **Agregar Libro**: Insertar un nuevo libro en la base de datos.
- **Actualizar Libro**: Modificar información de un libro existente.
- **Eliminar Libro**: Remover un libro de la base de datos.

## 🔐 Seguridad

Asegúrate de no exponer datos sensibles en tu código, especialmente si este es accesible por otros. Reemplaza o oculta datos críticos antes de compartirlo.

## 🤝 Contribución

¡Tu contribución es muy valiosa para mejorar el proyecto! Siéntete libre de abrir `issues` o `pull requests` para mejorar este proyecto para todos.
