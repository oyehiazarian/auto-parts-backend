package de.shop.auto_parts;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import de.shop.auto_parts.Security.model.User;
import de.shop.auto_parts.Security.repository.UserRepository;
import de.shop.auto_parts.Security.service.AuthenticationService;
import de.shop.auto_parts.Security.service.JwtService;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {


    @Mock
    private UserRepository userRepository;
    @Mock
    private User request;

    @InjectMocks
    private AuthenticationService authenticationService;

    @InjectMocks
    private JwtService jwtService;


    @Test
    void usernameAlreadyExists() {

        String existingUsername = "admin";

        when(request.getUsername()).thenReturn(existingUsername);

        when(userRepository.findByUsername(existingUsername)).thenReturn(Optional.of(new User()));

        assertThrows(ResponseStatusException.class, () -> {
            authenticationService.register(request);
        });

        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void verifyThatJwtTokenIsCreated(){
        String existingUsername = "admin";

        when(request.getUsername()).thenReturn(existingUsername);

        String token = jwtService.generateToken(request);

        assertNotNull(token, "Token should not be null");

        assertFalse(token.isEmpty(), "Token should not be empty");
    }

}
