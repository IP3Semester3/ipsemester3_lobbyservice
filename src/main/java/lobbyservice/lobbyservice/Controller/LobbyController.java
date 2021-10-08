package lobbyservice.lobbyservice.Controller;

import lobbyservice.lobbyservice.Model.lobby;
import lobbyservice.lobbyservice.Repository.LobbyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

    @RestController
    @RequestMapping("/api/v1")
    public class LobbyController {
        @Autowired
        private LobbyRepo _lobbyRepo;

        /**
         * Get all users list.
         *
         * @return the list
         */
        @GetMapping("/lobby")
        public List<lobby> getLobbys() {
            return _lobbyRepo.findAll();
        }
    }
