![](https://media.giphy.com/media/U4kOOpZGpTqz6dlYnE/giphy.gif)
# Lobby service
#### README
The lobby service will make it able to join and create lobby's. It is currently still under development. We created this service in Java Spring boot with JPA for the database side. With this service you will only need to insert the database and everything will be ready to go.
After this you will be able to implement the service to your own application via a RestAPI. The application is also tested with unit tests. They can be found at `/src/test/java/lobbyservice/lobbyservice/`.

## Gettings started
Welcome to the this repository for the lobbyservice. If you are new here please keep on reading, this way you will have all the information needed before working on the project. If you have been here before feel free to keep on working on the project. If you have worked before on one of our other services ( spotify service, roomservice-frontend). You will only need to read Docker, Database and Development. The other subjects are the same as in the other projects.

## Branches
Regarding the branches of the services. The project under development can be found in the development branch. You also need to push to this branch when you are developing with us and pushing the services. The unit tests can also be found in this branch. The Unit tests will automatically run when you pull request to the stable branch if the request gets accepted it gets pushed to the main branch and automatically updated in docker.

## Architecture
In the project we use the MVC principle. The folders can be found under src/main/java/lobbyservice.lobbyservice. From the controller the project returns a API. This way we can connect the project to a frontend of the users choice. The API will this way connect this project to an other project so that we can use a distributed architecture. You can see this more detaild in the C2 image below.

![C2](https://user-images.githubusercontent.com/78905924/143424170-f13b1110-eb65-4b86-8899-b074f21c4b3a.png)

## Development
During development we are using the default link for springboot `http://localhost:8080/`. The links we are using for different features for the API are as followed:
#### Get requests
- `/api/v1/lobby` : Gets an overview of all the avaible lobbys
- `/api/v1/lobby/{id}` : Gets the overview of the players in that specific lobby
#### Post requests
- `/api/v1/lobby/` : When a body is included this will create a lobby accrodingly to the information given in the body
- `/lobby/{id}/{username}` : Lets the user join the lobby with the id given in the link

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

## Docker

For docker we have two things that are used inside of this project. We have a single docker image called 'lobbyservice'. This is what the CI/CD checks and builds. But if you want to runt the program using docker you will need a database. To get this working you need to download the project go into the root of the project using your CMD and use `docker-compose -f docker-compose.yml up` to run the docker-compose.yml. This way you will create a docker compose with that pulls the project 'lobbyservice' project and the needed database with data. 

## Pull requests
Within this project we make use of pull requests to the stable branch. These pull requests will need to get reviewd within 24 hours of creation. This way you dont have to wait a really long time before the pull requests gets accepted. 

## Database
#### Lobby creation
For the creation of the lobby's there is a MySQL database available. This will be included in the project when you are using the docker compose version of the project as noted above. For testing of the project we used a localhost server with username: Root and no password. If you are using different credentials for your database be sure to edit the  application.properties and docker-compose.yml to your presonal credentials.

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
