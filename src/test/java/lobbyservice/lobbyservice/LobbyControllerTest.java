package lobbyservice.lobbyservice;

import com.fasterxml.jackson.databind.ObjectMapper;
import lobbyservice.lobbyservice.Controller.LobbyController;
import lobbyservice.lobbyservice.Model.lobby;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.*;

@WebMvcTest(LobbyControllerTest.class)
class LobbyControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    LobbyController _lobbyController;

    lobby RECORD_1 = new lobby(0, "lobby0");
    lobby RECORD_2 = new lobby(1, "lobby1");

    @Test
    public void getAllLobbysSuccesTest() throws Exception {
        List<lobby> lobbys = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2));
        Mockito.when(_lobbyController.getLobbys()).thenReturn(lobbys);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/lobby")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[1].lobbyname", is("lobby1")));
    }

    @Test
    public void getLobbyByIdSuccessTest() throws Exception {
        String jsonReturn = "{\"players\":[{\"id\":0,\"lobby_id\":0,\"username\":\"Tom\"},{\"id\":2,\"lobby_id\":0,\"username\":\"JanJansenEnDeKinderen\"},{\"id\":3,\"lobby_id\":0,\"username\":\"JanJansenEnDeKinderen\"},{\"id\":1,\"lobby_id\":0,\"username\":\"JanJansenEnDeKinderen\"}]}";
        HashMap<String, Object> hmap = new HashMap<String, Object>();
        hmap.put("count", 4);
        hmap.put("players", jsonReturn);
        ResponseEntity<?> responseEntity = new ResponseEntity<HashMap<String, Object>>(hmap, HttpStatus.OK);

        Mockito.when(_lobbyController.getLobbyById(RECORD_1.getId())).thenReturn((ResponseEntity<HashMap<String, Object>>) responseEntity);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/lobby/0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.count", is(4)));
    }

}
