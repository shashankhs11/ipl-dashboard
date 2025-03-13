package io.ipl.ipl_dashboard;

import java.util.List;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TeamControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    // Test 1: Team exists - should return 200 OK with team data
    @Test
    void testGetTeam() throws Exception {
        ResponseEntity<String> response = restTemplate.getForEntity("/team/Deccan Chargers", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        System.out.println("Response Body: " + response.getBody());
        System.out.println("Response Status Code: " + response.getStatusCode());

    //     DocumentContext documentContext = JsonPath.parse(response.getBody());
    //     String teamName = documentContext.read("$.teamName");
    //     assertThat(teamName).isEqualTo("Deccan Chargers");

    //     long totalMatches = documentContext.read("$.totalMatches");
    //     assertThat(totalMatches).isEqualTo(75);

    //     long totalWins = documentContext.read("$.totalWins");
    //     assertThat(totalWins).isEqualTo(29);
    }
    }
