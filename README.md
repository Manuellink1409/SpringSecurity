## Getting Started

To get a local copy up and running, follow these simple steps.

1. Clone the repository:
    ```sh
    git clone https://github.com/Manuellink1409/SpringSecurity-Master.git
    ```
2. Navigate to the project directory:
    ```sh
    cd security
    ```
3. Build the project using Maven:
    ```sh
    mvn clean install
    ```
4. Run the Spring Boot application:
    ```sh
    mvn spring-boot:run
    ```

## Endpoints

Here are some key endpoints:

```sh
POST /api/v1/auth/login - Authenticate and receive a JWT.
```
```sh
POST /api/v1/auth/register - Register a new user.
```
