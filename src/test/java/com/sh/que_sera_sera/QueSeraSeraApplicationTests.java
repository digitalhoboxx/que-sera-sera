package com.sh.que_sera_sera;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


@SpringBootTest
class QueSeraSeraApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

	@Test
	void shouldReturnSensorOutputWhenDataIsSaved() {
        ResponseEntity<String> response = restTemplate.getForEntity("/sensor/50", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        assertThat(id).isEqualTo(50);

        String data = documentContext.read("$.data");
        assertThat(data).isEqualTo("testdata");
    }

    @Test
    void shouldNotReturnASensorOutputWithAnUnknownId() {
        ResponseEntity<String> response = restTemplate.getForEntity("/sensor/100", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isBlank();
    }

}
