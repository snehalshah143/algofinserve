package tech.algofinserve.advisory.mapper;

import org.mapstruct.Mapper;
import tech.algofinserve.advisory.model.domain.Recommendation;
import tech.algofinserve.advisory.model.persistable.RecommendationPersistable;
@Mapper(componentModel = "spring")
public interface RecommendationMapper {

    RecommendationPersistable mapDomainToPersistable(Recommendation recommendation);
    Recommendation mapPersistableToDomain(RecommendationPersistable recommendationPersistable);
}
