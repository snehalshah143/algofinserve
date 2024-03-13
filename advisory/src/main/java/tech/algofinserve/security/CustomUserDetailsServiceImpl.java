package tech.algofinserve.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    public CustomUserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserPersistable userPersistable = (UserPersistable) userRepository.findByUsername(username);
        if (userPersistable == null) {
            throw new UsernameNotFoundException("User not found with username::"+username);
        }
         /*        Set<GrantedAuthority> grantedAuthorities = new HashSet();
    for (Role role : user.getRoles()){
        grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
    }
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);

    */
       User user= userMapper.mapPersistableToDomain(userPersistable);

        return new CustomUserDetails(user);
    }

}
