package tech.algofinserve.security;

import org.mapstruct.Mapper;
import tech.algofinserve.advisory.model.domain.InstrumentTickerAngel;
import tech.algofinserve.advisory.model.persistable.InstrumentTickerAngelPersistable;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserPersistable mapDomainToPersistable(User user);
    User mapPersistableToDomain(UserPersistable userPersistable);

    UserPersistable mapUserSignUpRequestToUserPersistable(UserSignUpRequest userSignUpRequest);

}
