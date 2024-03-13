package tech.algofinserve.security;

public interface UserService {

    UserPersistable save(UserPersistable user);

    UserPersistable findByUsername(String username);

    UserPersistable findByMobileNumber(String mobileNumber);

    boolean verifyPassword(UserSignUpRequest request);

    UserPersistable findByUserId(Long userId);


}
