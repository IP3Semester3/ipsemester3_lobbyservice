package lobbyservice.lobbyservice.Model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "lobbyservice")
@EntityListeners(AuditingEntityListener.class)
public class lobbyservice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long lobby_id;
    private String username;

    /** Gets id.
            *
            * @return the id
   */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
    }

    /** Gets id.
     *
     * @return the lobby_id
     */
    public long getLobby_id() {
        return lobby_id;
    }

    /**
     * Sets id.
     *
     * @param lobby_id the id
     */
    public void setLobby_id(long lobby_id) {
        this.lobby_id = lobby_id;
    }

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets first name.
     *
     * @param username the first name
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
