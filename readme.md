# Lobby service
#### README
The lobby service will make it able to join and create lobby's. We created this service in Java Spring boot with JPA for the database side. With this service you will only need to insert the database and everything will be ready to go.
After this you will be able to implement the service to your own application via a RestAPI. The application is also tested with unit tests. They can be found at {filename}.

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
