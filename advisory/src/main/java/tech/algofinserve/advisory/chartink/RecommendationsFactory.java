package tech.algofinserve.advisory.chartink;

public class RecommendationsFactory {

    public static RecommendationsFactory recommendationsFactory=new RecommendationsFactory();
    private RecommendationsFactory(){

    }

    public static RecommendationsFactory getRecommendationsFactoryInstance() {
        return recommendationsFactory;
    }


}
