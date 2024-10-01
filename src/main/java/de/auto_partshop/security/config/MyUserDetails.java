package de.auto_partshop.security.config;

import de.auto_partshop.security.models.MyUsers;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class MyUserDetails  implements UserDetails {

    private MyUsers users;
    public MyUserDetails(MyUsers users){
        this.users=users;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.stream(users.getRoles().split(",")).map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return users.getPassword();
    }

    @Override
    public String getUsername() {
        return users.getName();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
