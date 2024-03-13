package tech.algofinserve.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired private RoleRepository roleRepository;
    @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional(rollbackFor = Exception.class)
    public UserPersistable save(UserPersistable user) {
        String password = user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        //		user.setRoles(new HashSet(roleRepository.findAll()));
        UserPersistable savedUser = userRepository.save(user);
        return savedUser;
    }

    public boolean verifyPassword(UserSignUpRequest request) {
        return request.getPassword().equals(request.getPasswordConfirm());
    }

    public UserPersistable findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public UserPersistable findByUserId(Long userId) {
        return userRepository.findByUserId(userId);
    }


    @Override
    public UserPersistable findByMobileNumber(String mobileNumber) {
        return userRepository.findByMobileNumber(mobileNumber);
    }
}