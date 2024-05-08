package tech.algofinserve.advisory.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.StockData15Min;
import tech.algofinserve.advisory.model.persistable.StockData15MinPersistable;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-08T18:46:56+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 11.0.21 (Amazon.com Inc.)"
)
@Component
public class StockData15MinMapperImpl implements StockData15MinMapper {

    @Override
    public StockData15MinPersistable mapDomainToPersistable(StockData15Min stockData15Min) {
        if ( stockData15Min == null ) {
            return null;
        }

        StockData15MinPersistable stockData15MinPersistable = new StockData15MinPersistable();

        stockData15MinPersistable.setId( stockData15Min.getId() );
        stockData15MinPersistable.setCandleNum( stockData15Min.getCandleNum() );
        stockData15MinPersistable.setCandleTimeFrame( stockData15Min.getCandleTimeFrame() );
        stockData15MinPersistable.setSymbol( stockData15Min.getSymbol() );
        stockData15MinPersistable.setTimestamp( stockData15Min.getTimestamp() );
        stockData15MinPersistable.setOpen( stockData15Min.getOpen() );
        stockData15MinPersistable.setHigh( stockData15Min.getHigh() );
        stockData15MinPersistable.setLow( stockData15Min.getLow() );
        stockData15MinPersistable.setClose( stockData15Min.getClose() );
        stockData15MinPersistable.setVolume( stockData15Min.getVolume() );
        stockData15MinPersistable.setEma8( stockData15Min.getEma8() );
        stockData15MinPersistable.setEma13( stockData15Min.getEma13() );
        stockData15MinPersistable.setEma21( stockData15Min.getEma21() );
        stockData15MinPersistable.setEma34( stockData15Min.getEma34() );
        stockData15MinPersistable.setEma55( stockData15Min.getEma55() );
        stockData15MinPersistable.setEma89( stockData15Min.getEma89() );
        stockData15MinPersistable.setEma200( stockData15Min.getEma200() );
        stockData15MinPersistable.setRsi3( stockData15Min.getRsi3() );
        stockData15MinPersistable.setRsi14( stockData15Min.getRsi14() );
        stockData15MinPersistable.setRsi21( stockData15Min.getRsi21() );
        stockData15MinPersistable.setHull21( stockData15Min.getHull21() );
        stockData15MinPersistable.setHull55( stockData15Min.getHull55() );
        stockData15MinPersistable.setHull89( stockData15Min.getHull89() );
        stockData15MinPersistable.setVwap( stockData15Min.getVwap() );
        stockData15MinPersistable.setVwma21( stockData15Min.getVwma21() );
        stockData15MinPersistable.setRsi14ema9( stockData15Min.getRsi14ema9() );
        stockData15MinPersistable.setRsi14ema21( stockData15Min.getRsi14ema21() );
        stockData15MinPersistable.setIchimokuCloudTop( stockData15Min.getIchimokuCloudTop() );
        stockData15MinPersistable.setIchimokuCloudBottom( stockData15Min.getIchimokuCloudBottom() );
        stockData15MinPersistable.setIchimokuCloudBaseLine( stockData15Min.getIchimokuCloudBaseLine() );
        stockData15MinPersistable.setIchimokuCloudConversionLine( stockData15Min.getIchimokuCloudConversionLine() );
        stockData15MinPersistable.setMacd22107( stockData15Min.getMacd22107() );
        stockData15MinPersistable.setMacdSignal22107( stockData15Min.getMacdSignal22107() );
        stockData15MinPersistable.setMacdHist22107( stockData15Min.getMacdHist22107() );
        stockData15MinPersistable.setMacd26129( stockData15Min.getMacd26129() );
        stockData15MinPersistable.setMacdSignal26129( stockData15Min.getMacdSignal26129() );
        stockData15MinPersistable.setMacdHist26129( stockData15Min.getMacdHist26129() );
        stockData15MinPersistable.setMacd1153( stockData15Min.getMacd1153() );
        stockData15MinPersistable.setMacdSignal1153( stockData15Min.getMacdSignal1153() );
        stockData15MinPersistable.setMacdHist1153( stockData15Min.getMacdHist1153() );
        stockData15MinPersistable.setAtr( stockData15Min.getAtr() );
        stockData15MinPersistable.setDiPositive14( stockData15Min.getDiPositive14() );
        stockData15MinPersistable.setDinegative14( stockData15Min.getDinegative14() );
        stockData15MinPersistable.setAdx14( stockData15Min.getAdx14() );
        stockData15MinPersistable.setSupertrend103( stockData15Min.getSupertrend103() );
        stockData15MinPersistable.setSupertrend112( stockData15Min.getSupertrend112() );
        stockData15MinPersistable.setBbUpper202( stockData15Min.getBbUpper202() );
        stockData15MinPersistable.setBbLower202( stockData15Min.getBbLower202() );
        stockData15MinPersistable.setBbMiddle202( stockData15Min.getBbMiddle202() );
        stockData15MinPersistable.setOpenInterest( stockData15Min.getOpenInterest() );
        stockData15MinPersistable.setExchangeSegment( stockData15Min.getExchangeSegment() );
        stockData15MinPersistable.setInstrumentType( stockData15Min.getInstrumentType() );

        return stockData15MinPersistable;
    }

    @Override
    public StockData15Min mapPersistableToDomain(StockData15MinPersistable stockData15MinPersistable) {
        if ( stockData15MinPersistable == null ) {
            return null;
        }

        StockData15Min stockData15Min = new StockData15Min();

        stockData15Min.setId( stockData15MinPersistable.getId() );
        stockData15Min.setCandleNum( stockData15MinPersistable.getCandleNum() );
        stockData15Min.setCandleTimeFrame( stockData15MinPersistable.getCandleTimeFrame() );
        stockData15Min.setSymbol( stockData15MinPersistable.getSymbol() );
        stockData15Min.setTimestamp( stockData15MinPersistable.getTimestamp() );
        stockData15Min.setOpen( stockData15MinPersistable.getOpen() );
        stockData15Min.setHigh( stockData15MinPersistable.getHigh() );
        stockData15Min.setLow( stockData15MinPersistable.getLow() );
        stockData15Min.setClose( stockData15MinPersistable.getClose() );
        stockData15Min.setVolume( stockData15MinPersistable.getVolume() );
        stockData15Min.setEma8( stockData15MinPersistable.getEma8() );
        stockData15Min.setEma13( stockData15MinPersistable.getEma13() );
        stockData15Min.setEma21( stockData15MinPersistable.getEma21() );
        stockData15Min.setEma34( stockData15MinPersistable.getEma34() );
        stockData15Min.setEma55( stockData15MinPersistable.getEma55() );
        stockData15Min.setEma89( stockData15MinPersistable.getEma89() );
        stockData15Min.setEma200( stockData15MinPersistable.getEma200() );
        stockData15Min.setRsi3( stockData15MinPersistable.getRsi3() );
        stockData15Min.setRsi14( stockData15MinPersistable.getRsi14() );
        stockData15Min.setRsi21( stockData15MinPersistable.getRsi21() );
        stockData15Min.setHull21( stockData15MinPersistable.getHull21() );
        stockData15Min.setHull55( stockData15MinPersistable.getHull55() );
        stockData15Min.setHull89( stockData15MinPersistable.getHull89() );
        stockData15Min.setVwap( stockData15MinPersistable.getVwap() );
        stockData15Min.setVwma21( stockData15MinPersistable.getVwma21() );
        stockData15Min.setRsi14ema9( stockData15MinPersistable.getRsi14ema9() );
        stockData15Min.setRsi14ema21( stockData15MinPersistable.getRsi14ema21() );
        stockData15Min.setIchimokuCloudTop( stockData15MinPersistable.getIchimokuCloudTop() );
        stockData15Min.setIchimokuCloudBottom( stockData15MinPersistable.getIchimokuCloudBottom() );
        stockData15Min.setIchimokuCloudBaseLine( stockData15MinPersistable.getIchimokuCloudBaseLine() );
        stockData15Min.setIchimokuCloudConversionLine( stockData15MinPersistable.getIchimokuCloudConversionLine() );
        stockData15Min.setMacd22107( stockData15MinPersistable.getMacd22107() );
        stockData15Min.setMacdSignal22107( stockData15MinPersistable.getMacdSignal22107() );
        stockData15Min.setMacdHist22107( stockData15MinPersistable.getMacdHist22107() );
        stockData15Min.setMacd26129( stockData15MinPersistable.getMacd26129() );
        stockData15Min.setMacdSignal26129( stockData15MinPersistable.getMacdSignal26129() );
        stockData15Min.setMacdHist26129( stockData15MinPersistable.getMacdHist26129() );
        stockData15Min.setMacd1153( stockData15MinPersistable.getMacd1153() );
        stockData15Min.setMacdSignal1153( stockData15MinPersistable.getMacdSignal1153() );
        stockData15Min.setMacdHist1153( stockData15MinPersistable.getMacdHist1153() );
        stockData15Min.setAtr( stockData15MinPersistable.getAtr() );
        stockData15Min.setDiPositive14( stockData15MinPersistable.getDiPositive14() );
        stockData15Min.setDinegative14( stockData15MinPersistable.getDinegative14() );
        stockData15Min.setAdx14( stockData15MinPersistable.getAdx14() );
        stockData15Min.setSupertrend103( stockData15MinPersistable.getSupertrend103() );
        stockData15Min.setSupertrend112( stockData15MinPersistable.getSupertrend112() );
        stockData15Min.setBbUpper202( stockData15MinPersistable.getBbUpper202() );
        stockData15Min.setBbLower202( stockData15MinPersistable.getBbLower202() );
        stockData15Min.setBbMiddle202( stockData15MinPersistable.getBbMiddle202() );
        stockData15Min.setOpenInterest( stockData15MinPersistable.getOpenInterest() );
        stockData15Min.setExchangeSegment( stockData15MinPersistable.getExchangeSegment() );
        stockData15Min.setInstrumentType( stockData15MinPersistable.getInstrumentType() );

        return stockData15Min;
    }
}
