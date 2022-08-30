package com.jacopx.comments.service;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.jacopx.comments.entity.User;
import com.jacopx.comments.repository.UserRepository;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserService.class})
@ExtendWith(SpringExtension.class)
class UserServiceTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    /**
     * Method under test: {@link UserService#getUser(Long)}
     */
    @Test
    void testGetUser_ifUserIdProvided_thenReturnUser() {
        User user = new User();
        user.setCommentId(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPhone("4105551212");
        user.setProductId(new ArrayList<>());
        Optional<User> ofResult = Optional.of(user);
        when(userRepository.findById((Long) any())).thenReturn(ofResult);
        assertSame(user, userService.getUser(123L));
        verify(userRepository).findById((Long) any());
    }

    /**
     * Method under test: {@link UserService#createUser(User)}
     */
    @Test
    void testCreateUser_ifUserProvided_thenReturnUser() {
        User user = new User();
        user.setCommentId(new ArrayList<>());
        user.setEmail("jane.doe@example.org");
        user.setFirstName("Jane");
        user.setId(123L);
        user.setLastName("Doe");
        user.setPhone("4105551212");
        user.setProductId(new ArrayList<>());
        when(userRepository.save((User) any())).thenReturn(user);

        User user1 = new User();
        user1.setCommentId(new ArrayList<>());
        user1.setEmail("jane.doe@example.org");
        user1.setFirstName("Jane");
        user1.setId(123L);
        user1.setLastName("Doe");
        user1.setPhone("4105551212");
        user1.setProductId(new ArrayList<>());
        assertSame(user, userService.createUser(user1));
        verify(userRepository).save((User) any());
    }
}

