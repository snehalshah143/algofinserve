package tech.algofinserve.advisory.model.domain;

public enum RecommendationTimeFrame {

    INTRADAY("1 Day"),
    MOMENTUM("3-5 Days"),
    POSITIONAL("1 week to 1 Month"),
    SHORT_TERM("3 Months"),
    MEDIUM_TERM("6 Months"),
    LONG_TERM("1 Year");

    private final  String value;
    private RecommendationTimeFrame(String value){
        this.value=value;

    }
    public String value(){return this.value;}

    public RecommendationTimeFrame fromValue(String value){
        RecommendationTimeFrame[] recommendationTimeframes=values();

        for(int i = 0; i < recommendationTimeframes.length; ++i) {
            RecommendationTimeFrame c = recommendationTimeframes[i];
            if (c.value.equals(value)) {
                return c;
            }
        }

        throw new IllegalArgumentException(value);
    }


}
