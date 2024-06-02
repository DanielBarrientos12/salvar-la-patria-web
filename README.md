# Corrección de Segundo Parcial: API de Gestión de Mangas

Salvando la patria perdida del segundo parcial de programacion web. Esta API RESTful permite administrar una colección de mangas, incluyendo operaciones para obtener, crear, actualizar y eliminar mangas, así como gestionar mangas favoritos de usuarios.

## Endpoints

### Mangas

- **Obtener estado del servidor:**
  - **GET** `/mangas/status`
  - Respuesta exitosa:
    ```json
    {
        "message": "Servidor en funcionamiento",
        "timestamp": "2024-06-02T12:34:56"
    }
    ```

- **Obtener todos los mangas:**
  - **GET** `/mangas`
  - Respuesta exitosa:
    ```json
    [
        {
            "id": 1,
            "nombre": "Naruto",
            "fechaLanzamiento": "1999-09-21",
            "temporadas": 10,
            "pais": "Japón",
            "anime": true,
            "juego": false,
            "pelicula": true,
            "tipo": "Shonen"
        },
        {
            "id": 2,
            "nombre": "One Piece",
            "fechaLanzamiento": "1997-07-22",
            "temporadas": 20,
            "pais": "Japón",
            "anime": true,
            "juego": true,
            "pelicula": true,
            "tipo": "Shonen"
        }
    ]
    ```

- **Obtener manga por ID:**
  - **GET** `/mangas/{id}`
  - Respuesta exitosa:
    ```json
    {
        "id": 1,
        "nombre": "Naruto",
        "fechaLanzamiento": "1999-09-21",
        "temporadas": 10,
        "pais": "Japón",
        "anime": true,
        "juego": false,
        "pelicula": true,
        "tipo": "Shonen"
    }
    ```
  - Respuesta de error:
    ```json
    {
        "error": true,
        "msg": "Objeto no encontrado"
    }
    ```

- **Crear un nuevo manga:**
  - **POST** `/mangas`
  - Body de la solicitud:
    ```json
    {
        "nombre": "Bleach",
        "fechaLanzamiento": "2001-08-07",
        "temporadas": 16,
        "paisId": 1,
        "anime": true,
        "juego": true,
        "pelicula": true,
        "tipoId": 1
    }
    ```
  - Respuesta exitosa:
    ```json
    {
        "id": 3,
        "nombre": "Bleach",
        "fechaLanzamiento": "2001-08-07",
        "temporadas": 16,
        "pais": "Japón",
        "anime": true,
        "juego": true,
        "pelicula": true,
        "tipo": "Shonen"
    }
    ```
  - Respuesta de error por país no existente:
    ```json
    {
        "error": true,
        "msg": "Pais no existe"
    }
    ```
  - Respuesta de error por tipo no existente:
    ```json
    {
        "error": true,
        "msg": "Tipo no existe"
    }
    ```
  - Respuesta de error por campo obligatorio faltante:
    ```json
    {
        "error": true,
        "msg": "El campo nombre es obligatorio"
    }
    ```

- **Actualizar un manga existente:**
  - **PUT** `/mangas/{id}`
  - Body de la solicitud:
    ```json
    {
        "nombre": "Naruto Shippuden",
        "fechaLanzamiento": "2007-02-15",
        "temporadas": 20,
        "paisId": 1,
        "anime": true,
        "juego": true,
        "pelicula": true,
        "tipoId": 1
    }
    ```
  - Respuesta exitosa:
    ```json
    {
        "id": 1,
        "nombre": "Naruto Shippuden",
        "fechaLanzamiento": "2007-02-15",
        "temporadas": 20,
        "pais": "Japón",
        "anime": true,
        "juego": true,
        "pelicula": true,
        "tipo": "Shonen"
    }
    ```
  - Respuesta de error por ID de manga no existente:
    ```json
    {
        "error": true,
        "msg": "Objeto no encontrado"
    }
    ```

- **Eliminar un manga:**
  - **DELETE** `/mangas/{id}`
  - Respuesta exitosa:
    ```json
    {
        "id": 1,
        "nombre": "Naruto",
        "fechaLanzamiento": "1999-09-21",
        "temporadas": 10,
        "pais": "Japón",
        "anime": true,
        "juego": false,
        "pelicula": true,
        "tipo": "Shonen"
    }
    ```
  - Respuesta de error por ID de manga no existente:
    ```json
    {
        "error": true,
        "msg": "Objeto no encontrado"
    }
    ```
  - Respuesta de error por manga con usuarios asociados:
    ```json
    {
        "error": true,
        "msg": "Manga tiene usuarios asociados"
    }
    ```

### Usuarios

- **Obtener mangas favoritos de un usuario:**
  - **GET** `/usuarios/{username}/favoritos`
  - Respuesta exitosa:
    ```json
    [
        {
            "id": 1,
            "nombre": "Naruto",
            "fechaLanzamiento": "1999-09-21",
            "temporadas": 10,
            "pais": "Japón",
            "anime": true,
            "juego": false,
            "pelicula": true,
            "tipo": "Shonen"
        },
        {
            "id": 2,
            "nombre": "One Piece",
            "fechaLanzamiento": "1997-07-22",
            "temporadas": 20,
            "pais": "Japón",
            "anime": true,
            "juego": true,
            "pelicula": true,
            "tipo": "Shonen"
        }
    ]
    ```
  - Respuesta de error por usuario no existente:
    ```json
    {
        "error": true,
        "msg": "Objeto no encontrado"
    }
    ```

- **Agregar un manga a los favoritos de un usuario:**
  - **POST** `/usuarios/{username}/favoritos/{mangaId}`
  - Respuesta exitosa:
    ```json
    {
        "message": "Manga agregado a favoritos",
        "manga": {
            "id": 3,
            "nombre": "Bleach",
            "fechaLanzamiento": "2001-08-07",
            "temporadas": 16,
            "pais": "Japón",
            "anime": true,
            "juego": true,
            "pelicula": true,
            "tipo": "Shonen"
        }
    }
    ```
  - Respuesta de error por ID de manga no existente:
    ```json
    {
        "error": true,
        "msg": "Manga no encontrado"
    }
    ```
  - Respuesta de error por usuario no existente:
    ```json
    {
        "error": true,
        "msg": "Usuario no encontrado"
    }
    ```
  - Respuesta de error por manga ya registrado como favorito:
    ```json
    {
        "error": true,
        "msg": "Favorito ya se encuentra registrado"
    }
    ```

- **Eliminar un manga de los favoritos de un usuario:**
  - **DELETE** `/usuarios/{username}/favoritos/{mangaId}`
  - Respuesta exitosa:
    ```json
    {
        "message": "Manga eliminado de favoritos",
        "manga": {
            "id": 2,
            "nombre": "One Piece",
            "fechaLanzamiento": "1997-07-22",
            "temporadas": 20,
            "pais": "Japón",
            "anime": true,
            "juego": true,
            "pelicula": true,
            "tipo": "Shonen"
        }
    }
    ```
  - Respuesta de error por ID de manga no existente:
    ```json
    {
        "error": true,
        "msg": "Manga no encontrado"
    }
    ```
  - Respuesta de error por usuario no existente:
    ```json
    {
        "error": true,
        "msg": "Usuario no encontrado"
    }
    ```
  - Respuesta de error por manga no registrado como favorito:
    ```json
    {
        "error": true,
        "msg": "Favorito no encontrado"
    }
    ```
