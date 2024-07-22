
# Título: Cliente rest con java

## Descripción: 

Este proyecto es un cliente REST creado con Java que permite interactuar con API's a través de la terminal. El cliente está diseñado para facilitar el envío de solicitudes HTTP a una API REST y para recibir y procesar las respuestas de forma sencilla y eficiente. Se han agregado algunas caracteristicas, como enviar el body apartir de un archivo o guardar la respuesta en fichero. 

## Requisitos
* Java 17 o superior
* Gradle 8.8

## Instalación

### 1. Clonar repositorio

```bash
   git clone https://github.com/JuanAguileraAtaxca/proyecto-bootcamp-java.git
```

### 2. Ubicarse en el directorio del proyecto

```bash
   cd proyecto-bootcamp-java
```

### 3. Compilar y construir el proyecto
* Linux y mac Os

    ```bash
       ./gradlew build
    ```
* Windows

    ```bash
       gradlew.bat build
    ```

### 4. Uso

* Obtener una ayuda del uso

```bash
   ./gradlew run --args="-h"
   ./gradlew run --args="--help
   gradle run --args="-h"
   gradle run --args="--help"
```

salida: 

```bash
    Uso: gradle run --args="<verbo_http> [opciones]"

    Verbos http disponibles: 

    get         Realiza una petición GET para traer datos
                Uso: get <ruta>

    post        Realiza una petición POST para enviar datos
                Uso: post <ruta> <datos_json>

    put         Realiza una petición PUT para actualizar datos
                Uso: put <ruta> <datos_json>

    delete      Realiza una petición PUT para actualizar datos
                Uso: Delete <ruta>

    Opciones adicionales: 

    -h, --help      Muestra una ayuda del uso de la herramienta

    -f, --file      Envía los datos desde un archivo
                    Uso: <post o put> <ruta> -f <ruta_del_archivo>

    -o, --output     Los datos recibidos los guarda en un archivo
                    Uso: <get> <ruta> -o <ruta_archivo>
```

* Realizando una solicitud GET

```bash
   gradle run --args="GET https://jsonplaceholder.typicode.com/posts/1"
```

* Realizando un solicitud POST

    * Indicando el body desde terminal

    ```bash
        gradle run --args="POST https://jsonplaceholder.typicode.com/posts '"title":"foo","body":"bar","userId": 1'"
    ```
    * Indicando el body desde un archivo

    ```bash
       gradle run --args="POST https://jsonplaceholder.typicode.com/posts -f /home/juan/Escritorio/body.json"
    ```
    ```bash
       gradle run --args="POST https://jsonplaceholder.typicode.com/posts --file /home/juan/Escritorio/body.json"
    ```

* Realizando una petición PUT
    * Indicando el body en terminal

    ```bash
        gradle run --args="PUT https://jsonplaceholder.typicode.com/posts '"id": 1,"title":"foo","body": "bar","userId": 1'"
    ```

    * Indicando el body en un archivo
    ```bash
       gradle run --args="PUT https://jsonplaceholder.typicode.com/posts -f /home/juan/Escritorio/body.json"
    ```

* Realizando una petición DELETE

```bash
    gradle run --args="DELETE https://jsonplaceholder.typicode.com/posts/1"
```


## Estructura del proyecto

```
    proyecto-bootcamp/
    ├── build/
    │ ├── classes/
    │ ├── reports/
    │ └── libs/
    ├── src/
    │ ├── main/
    │ │ ├── java/
    │ │ │ └── proyecto/
    │ │ │    └── restcli/
    │ │ │       └── App.java
    │ │ │        └── RestClient.java
    │ │ │        └── commands
    │ │ │        │   └── GetCommand.java
    │ │ │        │   └── PostCommand.java
    │ │ │        │   └── PutCommand.java
    │ │ │        │   └── DeleteCommand.java
    │ │ │        └── utils
    │ │ │            └── Colores.java
    │ │ │            └── Formateador.java
    │ │ │            └── LecturaArchivo.java
    │ │ │            └── Menu.java
    │ │ │
    │ │ └── resources/
    │ └── test/
    │ ├── java/
    │ │   └── proyecto/
    │ │       └── restcli/
    │ │           └── AppTest.java
    │ └── resources/
    ├── .gitignore
    ├── .gitattributes
    ├── build.gradle
    ├── gradlew
    ├── gradlew.bat
    ├── settings.gradle
    └── README.md
```







