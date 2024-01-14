package tech.algofinserve.advisory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.algofinserve.advisory.chartink.RecommendationsDataFactory;
import tech.algofinserve.advisory.util.RecommendationHelper;
import tech.algofinserve.advisory.dao.RecommendationRepository;
import tech.algofinserve.advisory.mapper.RecommendationMapper;
import tech.algofinserve.advisory.model.domain.Recommendation;
import tech.algofinserve.advisory.model.persistable.RecommendationPersistable;

@Service
public class RecommendationServiceImpl implements RecommendationService{

    @Autowired
    RecommendationRepository recommendationRepository;

    @Autowired
    RecommendationMapper recommendationMapper;
    @Autowired
    RecommendationHelper recommendationHelper;
public RecommendationPersistable saveRecommendation(Recommendation recommendation){
     recommendationHelper.buildRecommendationDomainEntity(recommendation);
    RecommendationPersistable recommendationPersistable=recommendationMapper.mapDomainToPersistable(recommendation);

    return   recommendationRepository.save(recommendationPersistable);
}

}
