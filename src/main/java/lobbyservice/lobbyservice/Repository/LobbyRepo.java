package lobbyservice.lobbyservice.Repository;

import lobbyservice.lobbyservice.Model.lobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LobbyRepo extends JpaRepository<lobby, Long> { }
