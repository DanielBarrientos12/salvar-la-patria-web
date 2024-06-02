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
  - Respuesta exitosa (se muestran 3 ejemplos):
    ```json
    [
        {
            "id": 2,
            "nombre": "One Piece OMAR",
            "fechaLanzamiento": "1997-07-22",
            "temporadas": 20,
            "anime": 1,
            "juego": 1,
            "pelicula": 1,
            "pais": {
                "id": 2,
                "nombre": "China"
            },
            "tipo": {
                "id": 1,
                "nombre": "Shonen"
            }
        },
        {
            "id": 3,
            "nombre": "Attack on Titan",
            "fechaLanzamiento": "2009-09-09",
            "temporadas": 4,
            "anime": 1,
            "juego": 0,
            "pelicula": 1,
            "pais": {
                "id": 3,
                "nombre": "Korea"
            },
            "tipo": {
                "id": 3,
                "nombre": "Seinen"
            }
        },
        {
            "id": 4,
            "nombre": "Sailor Moon",
            "fechaLanzamiento": "1991-12-28",
            "temporadas": 5,
            "anime": 1,
            "juego": 0,
            "pelicula": 1,
            "pais": {
                "id": 4,
                "nombre": "Estados Unidos"
            },
            "tipo": {
                "id": 2,
                "nombre": "Shojo"
            }
        }
    ]
    ```

- **Obtener manga por ID:**
  - **GET** `/mangas/{id}`
  - Respuesta exitosa:
    ```json
    {
        "id": 20,
        "nombre": "Kaiju No. 8",
        "fechaLanzamiento": "2024-04-13",
        "temporadas": 1,
        "anime": 1,
        "juego": 0,
        "pelicula": 0,
        "pais": {
            "id": 1,
            "nombre": "Japón"
        },
        "tipo": {
            "id": 1,
            "nombre": "Shonen"
        }
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
        "nombre": "Death Note",
        "fechaLanzamiento": "2003-12-01",
        "temporadas": 1,
        "paisId": 1,
        "anime": 1,
        "juego": 1,
        "pelicula": 1,
        "tipoId": 1
    }
    ```
  - Respuesta exitosa:
    ```json
    {
        "id": 34,
        "nombre": "Death Note",
        "fechaLanzamiento": "2003-12-01",
        "temporadas": 1,
        "anime": 1,
        "juego": 1,
        "pelicula": 1,
        "pais": {
            "id": 1,
            "nombre": "Japón"
        },
        "tipo": {
            "id": 1,
            "nombre": "Shonen"
        }
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
        "nombre": "Death Note",
        "fechaLanzamiento": "2003-12-01",
        "temporadas": 1,
        "paisId": 1,
        "anime": 1,
        "juego": 1,
        "pelicula": 1,
        "tipoId": 3
    }
    ```
  - Respuesta exitosa:
    ```json
    {
        "id": 34,
        "nombre": "Death Note",
        "fechaLanzamiento": "2003-12-01",
        "temporadas": 1,
        "anime": 1,
        "juego": 1,
        "pelicula": 1,
        "pais": {
            "id": 1,
            "nombre": "Japón"
        },
        "tipo": {
            "id": 3,
            "nombre": "Seinen"
        }
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
        "id": 17,
        "nombre": "Naruto",
        "fechaLanzamiento": "1999-09-21",
        "temporadas": 10,
        "anime": 1,
        "juego": 0,
        "pelicula": 1,
        "pais": {
            "id": 1,
            "nombre": "Japón"
        },
        "tipo": {
            "id": 3,
            "nombre": "Seinen"
        }
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
  - Respuesta exitosa (se muestran 3 ejemplos):
    ```json
    [
        {
            "id": 2,
            "nombre": "One Piece OMAR",
            "fechaLanzamiento": "1997-07-22",
            "temporadas": 20,
            "anime": 1,
            "juego": 1,
            "pelicula": 1,
            "pais": {
                "id": 2,
                "nombre": "China"
            },
            "tipo": {
                "id": 1,
                "nombre": "Shonen"
            }
        },
        {
            "id": 5,
            "nombre": "Dragon Ball",
            "fechaLanzamiento": "1984-12-03",
            "temporadas": 9,
            "anime": 1,
            "juego": 1,
            "pelicula": 1,
            "pais": {
                "id": 5,
                "nombre": "Colombia"
            },
            "tipo": {
                "id": 1,
                "nombre": "Shonen"
            }
        },
        {
            "id": 6,
            "nombre": "Tokyo Ghoul",
            "fechaLanzamiento": "2011-09-08",
            "temporadas": 3,
            "anime": 1,
            "juego": 0,
            "pelicula": 0,
            "pais": {
                "id": 6,
                "nombre": "Inglaterra"
            },
            "tipo": {
                "id": 3,
                "nombre": "Seinen"
            }
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
  - Respuesta exitosa (se muestran 3 ejemplos):
    ```json
    [
        {
            "id": 2,
            "nombre": "One Piece OMAR",
            "fechaLanzamiento": "1997-07-22",
            "temporadas": 20,
            "anime": 1,
            "juego": 1,
            "pelicula": 1,
            "pais": {
                "id": 2,
                "nombre": "China"
            },
            "tipo": {
                "id": 1,
                "nombre": "Shonen"
            }
        },
        {
            "id": 6,
            "nombre": "Tokyo Ghoul",
            "fechaLanzamiento": "2011-09-08",
            "temporadas": 3,
            "anime": 1,
            "juego": 0,
            "pelicula": 0,
            "pais": {
                "id": 6,
                "nombre": "Inglaterra"
            },
            "tipo": {
                "id": 3,
                "nombre": "Seinen"
            }
        },
        {
            "id": 34,
            "nombre": "Death Note",
            "fechaLanzamiento": "2003-12-01",
            "temporadas": 1,
            "anime": 1,
            "juego": 1,
            "pelicula": 1,
            "pais": {
                "id": 1,
                "nombre": "Japón"
            },
            "tipo": {
                "id": 3,
                "nombre": "Seinen"
            }
        }
    ]
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
  - Respuesta exitosa (se muestran 3 ejemplos):
    ```json
    [
        {
            "id": 2,
            "nombre": "One Piece OMAR",
            "fechaLanzamiento": "1997-07-22",
            "temporadas": 20,
            "anime": 1,
            "juego": 1,
            "pelicula": 1,
            "pais": {
                "id": 2,
                "nombre": "China"
            },
            "tipo": {
                "id": 1,
                "nombre": "Shonen"
            }
        },
        {
            "id": 6,
            "nombre": "Tokyo Ghoul",
            "fechaLanzamiento": "2011-09-08",
            "temporadas": 3,
            "anime": 1,
            "juego": 0,
            "pelicula": 0,
            "pais": {
                "id": 6,
                "nombre": "Inglaterra"
            },
            "tipo": {
                "id": 3,
                "nombre": "Seinen"
            }
        },
        {
            "id": 20,
            "nombre": "Kaiju No. 8",
            "fechaLanzamiento": "2024-04-13",
            "temporadas": 1,
            "anime": 1,
            "juego": 0,
            "pelicula": 0,
            "pais": {
                "id": 1,
                "nombre": "Japón"
            },
            "tipo": {
                "id": 1,
                "nombre": "Shonen"
            }
        }
    ]
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

