package tech.algofinserve.advisory.service;

import tech.algofinserve.advisory.model.domain.Recommendation;
import tech.algofinserve.advisory.model.persistable.RecommendationPersistable;

public interface RecommendationService {

    RecommendationPersistable saveRecommendation(Recommendation recommendation);
}
