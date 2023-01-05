# Marvel Characters API

This is a Spring Boot API that consumes the public Marvel API and provides paginated access to Marvel characters. It
also has its own database to store the characters of each registered user of the application. The API is authenticated
and authorized using JSON Web Tokens (JWT).

# Prerequisites

* Java 11 or higher
* Maven 3.8.1 or higher
* A Marvel API key (https://developer.marvel.com/)

# Running the application

* Clone this repository.
* Create a file called application.properties in the src/main/resources folder and set the following properties:
    - marvel.api.key: Your Marvel API key.
    - marvel.api.secret: Your Marvel API secret.
    - spring.datasource.url: The URL of the database where you want to store the characters of the registered users.
    - spring.datasource.username: The username for the database.
    - spring.datasource.password: The password for the database.
* Run the following command to start the application:
    - Copy code: mvn spring-boot:run
* The API will be available at http://localhost:8080.

# API endpoints

### Health Controller

* /login: Returns a CustomResponseDTO and allows authenticated. @Post

### Login Controller

* /api/health: Allows you to check if the API is active.

### User Controller

* /api/user/save: Returns a UserDTO and allows saving the characters associated with a User. @Post
* /api/character/findByEmail: Returns a UserDTO and allows to find a Character by email. @Get

### Character Controller

* /character/save: Allows save the Characters and returns a list of type CharacterMarvelDTO, with the favorites of the
  logged in user. @Post
* /api/character/findAllFromMarvelApi: Returns a list of Marvel characters in the specified page. The page size is fixed
  to 20 characters by default. @Get
* /api/character/findByName: Allows to find a Character by name and return a CharacterMarvelDTO. @Get
* /api/character/findAllByUser: Allows to find characters by user ID and return a paginated list. Returns a list of type
  CharacterDTO. @Get
* /character/{id}/delete: Adds the character with the specified ID to the list of favorites of the logged in user.
  @Delete

# Technologies used

* Spring Boot JPA (Java Persistence API)
* Hibernate
* MapStruct
* PostgreSQL
