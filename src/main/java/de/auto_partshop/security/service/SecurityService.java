package de.auto_partshop.security.service;


import de.auto_partshop.security.models.MyUsers;
import de.auto_partshop.security.repository.SecurityRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SecurityService {
    private PasswordEncoder encoder;
    private SecurityRepository securityRepository;

    public void addUser(MyUsers users){
        users.setName(users.getName());
        users.setPassword(encoder.encode(users.getPassword()));
        securityRepository.save(users);
    }

}


