package io.tew88.rook.domain;

import io.dropwizard.jackson.Jackson;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.Test;

import static io.dropwizard.testing.FixtureHelpers.*;
import static org.assertj.core.api.Assertions.*;

public class UserTest {
    
    private static final ObjectMapper MAPPER = Jackson.newObjectMapper();
    
    @Test
    public void shouldSerialiseToJson() throws Exception {
        final User user = new User(1, "Tom Wadeson", "tom.wadeson@bt.com");
        
        assertThat(MAPPER.writeValueAsString(user))
            .isEqualTo(fixture("fixtures/user.json"));
    }
    
    @Test
    public void shouldDeserialiseFromJson() throws Exception {
        final User user = new User(1, "Tom Wadeson", "tom.wadeson@bt.com");
        
        assertThat(MAPPER.readValue(fixture("fixtures/user.json"), User.class))
            .isEqualToComparingFieldByField(user);
    }
}