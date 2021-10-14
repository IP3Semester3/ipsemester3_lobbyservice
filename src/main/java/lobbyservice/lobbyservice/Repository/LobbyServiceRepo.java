package lobbyservice.lobbyservice.Repository;


import lobbyservice.lobbyservice.Model.lobbyservice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LobbyServiceRepo extends JpaRepository<lobbyservice, Long>{
    @Query(nativeQuery = true, value = "SELECT * FROM lobbyservice.lobbyservice where lobby_id =?1")
    List<lobbyservice> getUsersByLobbyId(Long lobbyId);
}

