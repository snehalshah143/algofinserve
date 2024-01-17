package tech.algofinserve.advisory.constants;

public enum CandleTimeFrame {
    ONE_MINUTE("ONE_MINUTE"),
    THREE_MINUTE("THREE_MINUTE"),
    FIVE_MINUTE("FIVE_MINUTE"),
    TEN_MINUTE("TEN_MINUTE"),
    FIFTEEN_MINUTE("FIFTEEN_MINUTE"),
    THIRTY_MINUTE("THIRTY_MINUTE"),
    ONE_HOUR("ONE_HOUR"),
    ONE_DAY("ONE_DAY");

    private final  String value;
    private CandleTimeFrame(String value){
        this.value=value;

    }
    public String value(){return this.value;}

    public CandleTimeFrame fromValue(String value){
        CandleTimeFrame[] candleTimeFrames=values();

        for(int i = 0; i < candleTimeFrames.length; ++i) {
            CandleTimeFrame c = candleTimeFrames[i];
            if (c.value.equals(value)) {
                return c;
            }
        }

        throw new IllegalArgumentException(value);
    }

}
