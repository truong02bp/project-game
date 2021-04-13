package com.game.common.utils;

import com.game.MyUserDetails;
import com.game.data.dto.UserDto;
import com.game.data.entities.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class SecurityUtils {
    private static SecurityUtils securityUtils = null;
    private SecurityUtils(){}

    public static SecurityUtils getInstance(){
        if (securityUtils == null)
            securityUtils = new SecurityUtils();
        return securityUtils;
    }
    public boolean isAnonymous()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.isAuthenticated();
    }
    public boolean isGamePlayer(Set<User> users)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated())
            return false;
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        for (User user : users)
            if (user.getId() == userDetails.getUser().getId())
                return true;
        return false;
    }
    public boolean isPlayer(Set<UserDto> users)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication.isAuthenticated())
            return false;
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        for (UserDto user : users)
            if (user.getId() == userDetails.getUser().getId())
                return true;
        return false;
    }
    public List<String> getRoles()
    {
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        List<String> roles = new ArrayList<>();
        authorities.forEach(grantedAuthority -> {
            roles.add(grantedAuthority.getAuthority());
        });
        return roles;
    }
    public boolean isAdmin()
    {
        List<String> roles = getRoles();
        return roles.contains("ROLE_ADMIN");
    }
}
