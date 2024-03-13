package tech.algofinserve.security;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserPersistable, Long> {

    UserPersistable findByUsername(String username);


    UserPersistable findByUserId(Long userId);

    UserPersistable findByMobileNumber(String mobileNumber);
}
