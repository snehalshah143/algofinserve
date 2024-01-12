package tech.algofinserve.advisory.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import tech.algofinserve.advisory.model.persistable.RecommendationPersistable;
@Repository
public interface RecommendationRepository extends MongoRepository <RecommendationPersistable, Long> {


}
