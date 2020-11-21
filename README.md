# APIKeyAuthentication
It is a simple API Key authentication implementation using spring security.

# How to run this
1. git clone git@github.com:CodeMagik/APIKeyAuthentication.git
2. ./mvnw clean package
3. ./mvnw spring-boot:run
4. It will start running in port 8080

# How to hit the API
## Unsecured api - It deosnt require api key
  ``` 
  curl localhost:8080/api/isAlive 
  I am alive, you dont need authentication to check whether I am alive
  
  ```

## Secured api - It requires api key
  ``` 
  curl -X GET -H "Authorization: ApiKey demoApiKey" localhost:8080/api/hello 
  hello
  ```
