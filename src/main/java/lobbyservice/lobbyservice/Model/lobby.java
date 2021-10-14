package lobbyservice.lobbyservice.Model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "lobby")
@EntityListeners(AuditingEntityListener.class)
public class lobby {
    @Id
    private long id;
    private String lobbyname;

    /* Gets id.
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

    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getLobbyname() {
        return lobbyname;
    }

    /**
     * Sets first name.
     *
     * @param lobbyname the first name
     */
    public void setLobbyname(String lobbyname) {
        this.lobbyname = lobbyname;
    }
}
