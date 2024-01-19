package tech.algofinserve.advisory.core;

import org.ta4j.core.BarSeries;
import org.ta4j.core.indicators.*;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;
import tech.algofinserve.advisory.model.domain.*;


public final class MomentumTechnicalIndicatorHelper extends AbstractTechnicalIndicator {


private BarSeries barSeries;








  private MomentumTechnicalIndicatorHelper(BarSeries barSeries){

      this.barSeries=barSeries;
      closePriceIndicator=closePriceIndicatorFunction.apply(barSeries);

  }

    public static MomentumTechnicalIndicatorHelper getMomentumTechnicalIndicatorHelper(BarSeries barSeries){
      return new MomentumTechnicalIndicatorHelper(barSeries);
    }
//OHLC
    private ClosePriceIndicator closePriceIndicator;

    public ClosePriceIndicator getClosePriceIndicator(BarSeries barSeries) {
        closePriceIndicator=closePriceIndicatorFunction.apply(barSeries);
        return closePriceIndicator;
    }

//MACD

    //26-12
    private  MACDIndicator macdIndicator2612;
    private MACDSignalIndicator macdSignal26129;
    private MACDIndicator macdIndicator2210;
    private MACDSignalIndicator macdSignal22107;


    public MACDIndicator getMacdIndicator(Integer shortMovAvg,Integer longMovAvg){

        return new MACDIndicator(closePriceIndicator,shortMovAvg,longMovAvg);
    }

    public MACDIndicator getMacdIndicator2612(){

        if(macdIndicator2612==null){
            macdIndicator2612=getMacdIndicator(12,26);
        }
        return  macdIndicator2612;
    }

    public MACDSignalIndicator getMACDSignalIndicator26129(){

        if(macdSignal26129==null){
            macdSignal26129=new MACDSignalIndicator(getMacdIndicator2612(),9);
        }
        return  macdSignal26129;
    }

    public MACDIndicator getMACDIndicator2210(){

        if(macdIndicator2210==null){
            macdIndicator2210=getMacdIndicator(10,22);
        }
        return  macdIndicator2210;
    }

    public MACDSignalIndicator getMACDSignalIndicator22107(){

        if(macdSignal22107==null){
            macdSignal22107=new MACDSignalIndicator(getMACDIndicator2210(),7);
        }
        return  macdSignal22107;
    }



    public MACD getMACD26129(Integer index){
double macd=getMacdIndicator2612().getValue(index).doubleValue();
double  macdSignal=getMACDSignalIndicator26129().getValue(index).doubleValue();
double hist=macd -macdSignal;
      return  new MACD(macd,macdSignal,hist);
    }

    public MACD getMACD22107(Integer index){
        double macd=getMACDIndicator2210().getValue(index).doubleValue();
        double  macdSignal=getMACDSignalIndicator22107().getValue(index).doubleValue();
        double hist=macd -macdSignal;
        return  new MACD(macd,macdSignal,hist);

    }

    //RSI

    private RSIIndicator rsiIndicator14;
    private RSIIndicator rsiIndicator3;
    private RSIIndicator rsiIndicator21;

    private RSISignalIndicator rsiSignalIndicator14_9;
    private RSISignalIndicator rsiSignalIndicator14_21;
    private RSISignalIndicator rsiSignalIndicator3_9;
    private RSISignalIndicator rsiSignalIndicator3_21;


    public RSIIndicator getRSIIndicator(Integer parameter){

        return new RSIIndicator(closePriceIndicator,parameter);
    }
    public RSIIndicator getRSIIndicator14(){

        if(rsiIndicator14==null){
            rsiIndicator14=getRSIIndicator(14);
        }
        return  rsiIndicator14;
    }

    public RSIIndicator getRSIIndicator3(){

        if(rsiIndicator3==null){
            rsiIndicator3=getRSIIndicator(3);
        }
        return  rsiIndicator3;
    }

    public RSIIndicator getRSIIndicator21(){

        if(rsiIndicator21==null){
            rsiIndicator21=getRSIIndicator(21);
        }
        return  rsiIndicator21;
    }

    public RSISignalIndicator getRSISignalIndicator14_9(){

        if(rsiSignalIndicator14_9==null){
            rsiSignalIndicator14_9=new RSISignalIndicator(getRSIIndicator14(),9);
        }
        return  rsiSignalIndicator14_9;
    }

    public RSISignalIndicator getRSISignalIndicator14_21(){

        if(rsiSignalIndicator14_21==null){
            rsiSignalIndicator14_21=new RSISignalIndicator(getRSIIndicator14(),21);
        }
        return  rsiSignalIndicator14_21;
    }

    public RSISignalIndicator getRSISignalIndicator3_9(){

        if(rsiSignalIndicator3_9==null){
            rsiSignalIndicator3_9=new RSISignalIndicator(getRSIIndicator3(),9);
        }
        return  rsiSignalIndicator3_9;
    }
    public RSISignalIndicator getRSISignalIndicator3_21(){

        if(rsiSignalIndicator3_21==null){
            rsiSignalIndicator3_21=new RSISignalIndicator(getRSIIndicator3(),21);
        }
        return  rsiSignalIndicator3_21;
    }


    public RSI getRSI14(Integer index){
        double rsi=getRSIIndicator14().getValue(index).doubleValue();
        double rsiema9=getRSISignalIndicator14_9().getValue(index).doubleValue();
        double rsiema21=getRSISignalIndicator14_21().getValue(index).doubleValue();
        return  new RSI(rsi,rsiema9,rsiema21);
    }

    public RSI getRSI3(Integer index){
        double rsi=getRSIIndicator3().getValue(index).doubleValue();
        double rsiema21=getRSISignalIndicator3_21().getValue(index).doubleValue();
        return  new RSI(rsi,null,rsiema21);
    }

//EMA

    private EMAIndicator emaIndicator5;
    private EMAIndicator emaIndicator8;
    private EMAIndicator emaIndicator13;
    private EMAIndicator emaIndicator21;
    private EMAIndicator emaIndicator34;
    private EMAIndicator emaIndicator55;
    private EMAIndicator emaIndicator200;

    public EMAIndicator getEMAIndicator(Integer parameter){

        return new EMAIndicator(closePriceIndicator,parameter);
    }
    public EMAIndicator getEMAIndicator5(){

        if(emaIndicator5==null){
            emaIndicator5=getEMAIndicator(5);
        }
        return  emaIndicator5;
    }

    public EMAIndicator getEMAIndicator8(){

        if(emaIndicator8==null){
            emaIndicator8=getEMAIndicator(8);
        }
        return  emaIndicator8;
    }
    public EMAIndicator getEMAIndicator13(){

        if(emaIndicator13==null){
            emaIndicator13=getEMAIndicator(13);
        }
        return  emaIndicator13;
    }

    public EMAIndicator getEMAIndicator21(){

        if(emaIndicator21==null){
            emaIndicator21=getEMAIndicator(21);
        }
        return  emaIndicator21;
    }

    public EMAIndicator getEMAIndicator34(){

        if(emaIndicator34==null){
            emaIndicator34=getEMAIndicator(34);
        }
        return  emaIndicator34;
    }
    public EMAIndicator getEMAIndicator55(){

        if(emaIndicator55==null){
            emaIndicator55=getEMAIndicator(55);
        }
        return  emaIndicator55;
    }

    public EMAIndicator getEMAIndicator200(){

        if(emaIndicator200==null){
            emaIndicator200=getEMAIndicator(200);
        }
        return  emaIndicator200;
    }

//HULL
    private HMAIndicator hullIndicator21;
    private HMAIndicator hullIndicator55;
    private HMAIndicator hullIndicator89;

    public HMAIndicator getHULLIndicator(Integer parameter){

        return new HMAIndicator(closePriceIndicator,parameter);
    }
    public HMAIndicator getHULLIndicator21(){

        if(hullIndicator21==null){
            hullIndicator21=getHULLIndicator(21);
        }
        return  hullIndicator21;
    }

    public HMAIndicator getHULLIndicator55(){

        if(hullIndicator55==null){
            hullIndicator55=getHULLIndicator(55);
        }
        return  hullIndicator55;
    }

    public HMAIndicator getHULLIndicator89(){

        if(hullIndicator89==null){
            hullIndicator89=getHULLIndicator(89);
        }
        return  hullIndicator89;
    }

    //KST
    private KSTIndicator kstIndicator;
    private KSTSignalIndicator kstSignalIndicator;


    public KSTIndicator getKSTIndicator(){

        if(kstIndicator==null){
            kstIndicator=new KSTIndicator(closePriceIndicator);
        }
        return  kstIndicator;
    }

    public KSTSignalIndicator getKSTSignalIndicator(){

        if(kstSignalIndicator==null){
            kstSignalIndicator=new KSTSignalIndicator(getKSTIndicator(),9);
        }
        return  kstSignalIndicator;
    }

}
