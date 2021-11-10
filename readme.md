# Lobby service
#### README
The lobby service will make it able to join and create lobby's. We created this service in Java Spring boot with JPA for the database side. With this service you will only need to insert the database and everything will be ready to go.
After this you will be able to implement the service to your own application via a RestAPI. The application is also tested with unit tests. They can be found at {filename}.

## Branches
Regarding the branches of the services. The project under development can be found in the development branch. You also need to push to this branch when you are developing with us and pushing the services. The unit tests can also be found in this branch. The Unit tests will automatically run when you pull request to the stable branch if the request gets accepted it gets pushed to the main branch and automatically updated in docker.
## Architecture
In the project we use the MVC principle. The folders can be found under src/main/java/lobbyservice.lobbyservice. From the controller the project returns a API. This way we can connect the project to a frontend of the users choice. The API will this way connect this project to an other project so that we can use a distributed architecture. 

## Coding guidelines
In this project we use the Java standard coding convetions they can be found at https://www.oracle.com/java/technologies/javase/codeconventions-contents.html.
Above each method pseudocode can be found. This describes what the function does, what parameters it has, what it returns and if necessary what exception it throws. The template for this can be found underneath 
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

## Planning
For the planning of this project we created a Jira board. The Jira board of the project can be found in the following link https://semseter3-ip-tomeykholt.atlassian.net/jira/software/projects/SEM3/boards/2 . For this part of the whole project noted in Jira you can look al user story SEM3-30. This is the user story that is connected to this service. 

### Sources
https://dzone.com/articles/how-to-create-rest-api-with-spring-boot
