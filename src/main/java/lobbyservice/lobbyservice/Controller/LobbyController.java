package lobbyservice.lobbyservice.Controller;

import lobbyservice.lobbyservice.Model.ResourceNotFoundException;
import lobbyservice.lobbyservice.Model.lobby;
import lobbyservice.lobbyservice.Model.lobbyservice;
import lobbyservice.lobbyservice.Repository.LobbyRepo;
import lobbyservice.lobbyservice.Repository.LobbyServiceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
    @RequestMapping("/api/v1")
    public class LobbyController {
        @Autowired
        private LobbyRepo _lobbyRepo;
        @Autowired
        private LobbyServiceRepo _lobbyServiceRepo;

        /**
         * Get all users list.
         *
         * @return the list
         */
        @GetMapping("/lobby")
        public  List<lobby> getLobbys() {
            return _lobbyRepo.findAll();
        }

        /**
         * Gets users by lobby id.
         *
         * @param lobbyId the lobby id
         * @return the users by lobby id
         * @throws ResourceNotFoundException the resource not found exception
         */
        @GetMapping("/lobby/{id}")
        public ResponseEntity<HashMap<String, Object>> getLobbyById(@PathVariable(value = "id") Long lobbyId)
                throws ResourceNotFoundException {
            List<lobbyservice> lobby =
                    _lobbyServiceRepo
                            .getUsersByLobbyId(lobbyId);

            HashMap<String, Object> hmap = new HashMap<String, Object>();
            hmap.put("count", lobby.size());
            hmap.put("players", lobby);

            return new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);
        }

        /**
         * Create lobby lobby.
         *
         * @param lobby the lobby
         * @return the lobby
         */
        @PostMapping("/lobby")
        public lobby createLobby(@Valid @RequestBody lobby lobby) {
            return _lobbyRepo.save(lobby);
        }

        /**
         * Update lobby response entity.
         *
         * @param lobbyId the lobby id
         * @param lobbyDetails the user details
         * @return the response entity
         * @throws ResourceNotFoundException the resource not found exception
         */
        @PostMapping("/lobby/{id}")
        public ResponseEntity<lobby> updateLobby(
                @PathVariable(value = "id") Long lobbyId, @Valid @RequestBody lobby lobbyDetails)
                throws ResourceNotFoundException {

            lobby _lobby =
                    _lobbyRepo
                            .findById(lobbyId)
                            .orElseThrow(() -> new ResourceNotFoundException("Lobby not found on :: " + lobbyId));

            _lobby.setLobbyname(lobbyDetails.getLobbyname());
            _lobby.setId(lobbyDetails.getId());
            final lobby updatedLobby = _lobbyRepo.save(_lobby);
            return ResponseEntity.ok(updatedLobby);
        }

        /**
         * Update lobby response entity.
         *
         * @param lobbyId the lobby id
         * @return the response entity
         * @throws ResourceNotFoundException the resource not found exception
         */
        @PostMapping("/lobby/{id}/{username}")
        public ResponseEntity<lobbyservice> joinLobby(
                @PathVariable(value = "id") Long lobbyId,  @PathVariable(value = "username") String username)
                throws ResourceNotFoundException {

            lobby _lobby =
                    _lobbyRepo
                            .findById(lobbyId)
                            .orElseThrow(() -> new ResourceNotFoundException("Lobby not found on :: " + lobbyId));

            System.out.println(_lobby);
            lobbyservice _lobbyservice = new lobbyservice();
            _lobbyservice.setLobby_id(_lobby.getId());
            _lobbyservice.setUsername(username);
            final lobbyservice updatedLobby = _lobbyServiceRepo.save(_lobbyservice);
            return ResponseEntity.ok(updatedLobby);
        }
    }
