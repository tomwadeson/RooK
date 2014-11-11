package io.tew88.rook.resources;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

import io.dropwizard.testing.junit.ResourceTestRule;
import io.tew88.rook.domain.User;
import io.tew88.rook.domain.dao.UserDao;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class UserResourceTest {
    
    private static final UserDao userDao = mock(UserDao.class);
    
    @Rule
    public final ResourceTestRule resources = ResourceTestRule.builder()
        .addResource(new UserResource(userDao))
        .build();
    
    private final User user = new User(1, "User", "user@example.com");
    
    @Before
    public void setUp() {
        when(userDao.findById(eq(1))).thenReturn(user);
    }
    
    @Test
    public void shouldGetUserById() {
        assertThat(resources.client().resource("/users/1").get(User.class))
            .isEqualToComparingFieldByField(user);
    }
}