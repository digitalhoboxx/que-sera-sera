package com.sh.que_sera_sera;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContentAssert;
import org.springframework.boot.test.json.*;

import java.io.IOException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JsonTest
class SensorOutputJsonTest {
    @Autowired
    private JacksonTester<SensorOutput> json;

    @Test
    void sensorOutputSerializationTest() throws IOException {
        SensorOutput sensorOutput = new SensorOutput(50L, "testdata");
        assertThat(json.write(sensorOutput)).isEqualTo("expected.json");

    }
}
