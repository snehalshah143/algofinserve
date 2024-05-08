package tech.algofinserve.security;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-08T18:46:56+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 11.0.21 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserPersistable mapDomainToPersistable(User user) {
        if ( user == null ) {
            return null;
        }

        UserPersistable userPersistable = new UserPersistable();

        userPersistable.setUserId( user.getUserId() );
        userPersistable.setUsername( user.getUsername() );
        userPersistable.setPassword( user.getPassword() );
        userPersistable.setFirstName( user.getFirstName() );
        userPersistable.setLastName( user.getLastName() );
        userPersistable.setEmail( user.getEmail() );
        userPersistable.setMobileNumber( user.getMobileNumber() );
        userPersistable.setLoggedIn( user.isLoggedIn() );

        return userPersistable;
    }

    @Override
    public User mapPersistableToDomain(UserPersistable userPersistable) {
        if ( userPersistable == null ) {
            return null;
        }

        User user = new User();

        user.setUserId( userPersistable.getUserId() );
        user.setEmail( userPersistable.getEmail() );
        user.setUsername( userPersistable.getUsername() );
        user.setMobileNumber( userPersistable.getMobileNumber() );
        user.setLoggedIn( userPersistable.isLoggedIn() );
        user.setPassword( userPersistable.getPassword() );
        user.setFirstName( userPersistable.getFirstName() );
        user.setLastName( userPersistable.getLastName() );

        return user;
    }

    @Override
    public UserPersistable mapUserSignUpRequestToUserPersistable(UserSignUpRequest userSignUpRequest) {
        if ( userSignUpRequest == null ) {
            return null;
        }

        UserPersistable userPersistable = new UserPersistable();

        userPersistable.setPassword( userSignUpRequest.getPassword() );
        userPersistable.setFirstName( userSignUpRequest.getFirstName() );
        userPersistable.setLastName( userSignUpRequest.getLastName() );
        userPersistable.setEmail( userSignUpRequest.getEmail() );
        userPersistable.setMobileNumber( userSignUpRequest.getMobileNumber() );

        return userPersistable;
    }
}
