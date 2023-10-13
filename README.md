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

## ▶️ Configuración y Ejecución

### Configuración de Oracle Wallet
1. Descarga tu wallet de Oracle Cloud.
2. Colócalo en una ubicación segura en tu máquina.
3. Configura el path del wallet en la clase `ConexionBD`.
4. Configura `URL`, `USER` y `PASSWORD` en la clase `ConexionBD`.
```java
System.setProperty("oracle.net.tns_admin", "[PATH_TO_YOUR_WALLET]");
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
