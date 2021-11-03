# Lobby service
#### README
The lobby service will make it able to join and create lobby's. We created this service in Java Spring boot with JPA for the database side. With this service you will only need to insert the database and everything will be ready to go.
After this you will be able to implement the service to your own application via a RestAPI. The application is also tested with unit tests. They can be found at {filename}.

## Branches
Regarding the branches of the services. The project under development can be found in the development branch. You also need to push to this branch when you are developing with us and pushing the services. The project that includes the unit testing of the project can be found at the testing branch. If you want to test the code you added you can set a pull request from development to testing. This will get checked and if everything is correct the pull request will get accepted. If you want to edit or add tests you can switch to the testing branch and push to that branch.

## Architecture
In the project we use the MVC principle. The folders can be found under src/main/java/lobbyservice.lobbyservice. From the controller the project returns a API. This way we can connect the project to a frontend of the users choice. The API will this way connect this project to a other project so that we can use a distributed architecture. 

## Coding guidelines
Above each method pseudo code can be found. This describes what the function does, what parameters it has, what it returns and if necessary what exception it throws. The template for this can be found underneath 
````
/*
    {What does the function do}
 
    @param {Parameters}
    @return {returns}
    @throws {Exception if necessary}
 */
````


## Database
#### Lobby creation
For the creation of the lobby's there is a MySQL database available we have included it as a .sql file. The only thing left to do
when you initiated the file is to connect your database data in the system. To do this you will need to edit the application.properties file and 
insert your own database username and password. The database will connect to the system via a rest API. 

The moment that a lobby closed it will be deleted out of the database. This option will only be available when everyone has left
the lobby.

#### Lobby joining
The user will also be able to join lobby's that are available if the room code was giving to the user. For the joining of the lobby's we
have made a seperated database tabel. In this tabel we have connected the users to the room code. The username of the user
will also be pushed to the screen when he joins. This way there will be a clear view of the users that are currently in the lobby.


### Sources
https://dzone.com/articles/how-to-create-rest-api-with-spring-boot
