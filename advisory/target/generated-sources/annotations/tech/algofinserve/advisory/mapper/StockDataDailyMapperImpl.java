package tech.algofinserve.advisory.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.StockDataDaily;
import tech.algofinserve.advisory.model.persistable.StockDataDailyPersistable;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-21T19:21:16+0530",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 11.0.21 (Amazon.com Inc.)"
)
@Component
public class StockDataDailyMapperImpl implements StockDataDailyMapper {

    @Override
    public StockDataDailyPersistable mapDomainToPersistable(StockDataDaily stockDataDaily) {
        if ( stockDataDaily == null ) {
            return null;
        }

        StockDataDailyPersistable stockDataDailyPersistable = new StockDataDailyPersistable();

        stockDataDailyPersistable.setId( stockDataDaily.getId() );
        stockDataDailyPersistable.setCandleNum( stockDataDaily.getCandleNum() );
        stockDataDailyPersistable.setCandleTimeFrame( stockDataDaily.getCandleTimeFrame() );
        stockDataDailyPersistable.setSymbol( stockDataDaily.getSymbol() );
        stockDataDailyPersistable.setTimestamp( stockDataDaily.getTimestamp() );
        stockDataDailyPersistable.setOpen( stockDataDaily.getOpen() );
        stockDataDailyPersistable.setHigh( stockDataDaily.getHigh() );
        stockDataDailyPersistable.setLow( stockDataDaily.getLow() );
        stockDataDailyPersistable.setClose( stockDataDaily.getClose() );
        stockDataDailyPersistable.setVolume( stockDataDaily.getVolume() );
        stockDataDailyPersistable.setEma8( stockDataDaily.getEma8() );
        stockDataDailyPersistable.setEma13( stockDataDaily.getEma13() );
        stockDataDailyPersistable.setEma21( stockDataDaily.getEma21() );
        stockDataDailyPersistable.setEma34( stockDataDaily.getEma34() );
        stockDataDailyPersistable.setEma55( stockDataDaily.getEma55() );
        stockDataDailyPersistable.setEma89( stockDataDaily.getEma89() );
        stockDataDailyPersistable.setEma200( stockDataDaily.getEma200() );
        stockDataDailyPersistable.setRsi3( stockDataDaily.getRsi3() );
        stockDataDailyPersistable.setRsi14( stockDataDaily.getRsi14() );
        stockDataDailyPersistable.setRsi21( stockDataDaily.getRsi21() );
        stockDataDailyPersistable.setHull21( stockDataDaily.getHull21() );
        stockDataDailyPersistable.setHull55( stockDataDaily.getHull55() );
        stockDataDailyPersistable.setHull89( stockDataDaily.getHull89() );
        stockDataDailyPersistable.setVwap( stockDataDaily.getVwap() );
        stockDataDailyPersistable.setVwma21( stockDataDaily.getVwma21() );
        stockDataDailyPersistable.setRsi14ema9( stockDataDaily.getRsi14ema9() );
        stockDataDailyPersistable.setRsi14ema21( stockDataDaily.getRsi14ema21() );
        stockDataDailyPersistable.setIchimokuCloudTop( stockDataDaily.getIchimokuCloudTop() );
        stockDataDailyPersistable.setIchimokuCloudBottom( stockDataDaily.getIchimokuCloudBottom() );
        stockDataDailyPersistable.setIchimokuCloudBaseLine( stockDataDaily.getIchimokuCloudBaseLine() );
        stockDataDailyPersistable.setIchimokuCloudConversionLine( stockDataDaily.getIchimokuCloudConversionLine() );
        stockDataDailyPersistable.setMacd22107( stockDataDaily.getMacd22107() );
        stockDataDailyPersistable.setMacdSignal22107( stockDataDaily.getMacdSignal22107() );
        stockDataDailyPersistable.setMacdHist22107( stockDataDaily.getMacdHist22107() );
        stockDataDailyPersistable.setMacd26129( stockDataDaily.getMacd26129() );
        stockDataDailyPersistable.setMacdSignal26129( stockDataDaily.getMacdSignal26129() );
        stockDataDailyPersistable.setMacdHist26129( stockDataDaily.getMacdHist26129() );
        stockDataDailyPersistable.setMacd1153( stockDataDaily.getMacd1153() );
        stockDataDailyPersistable.setMacdSignal1153( stockDataDaily.getMacdSignal1153() );
        stockDataDailyPersistable.setMacdHist1153( stockDataDaily.getMacdHist1153() );
        stockDataDailyPersistable.setAtr( stockDataDaily.getAtr() );
        stockDataDailyPersistable.setDiPositive14( stockDataDaily.getDiPositive14() );
        stockDataDailyPersistable.setDinegative14( stockDataDaily.getDinegative14() );
        stockDataDailyPersistable.setAdx14( stockDataDaily.getAdx14() );
        stockDataDailyPersistable.setSupertrend103( stockDataDaily.getSupertrend103() );
        stockDataDailyPersistable.setSupertrend112( stockDataDaily.getSupertrend112() );
        stockDataDailyPersistable.setBbUpper202( stockDataDaily.getBbUpper202() );
        stockDataDailyPersistable.setBbLower202( stockDataDaily.getBbLower202() );
        stockDataDailyPersistable.setBbMiddle202( stockDataDaily.getBbMiddle202() );
        stockDataDailyPersistable.setOpenInterest( stockDataDaily.getOpenInterest() );
        stockDataDailyPersistable.setExchangeSegment( stockDataDaily.getExchangeSegment() );
        stockDataDailyPersistable.setInstrumentType( stockDataDaily.getInstrumentType() );

        return stockDataDailyPersistable;
    }

    @Override
    public StockDataDaily mapPersistableToDomain(StockDataDailyPersistable stockDataDailyPersistable) {
        if ( stockDataDailyPersistable == null ) {
            return null;
        }

        StockDataDaily stockDataDaily = new StockDataDaily();

        stockDataDaily.setId( stockDataDailyPersistable.getId() );
        stockDataDaily.setCandleNum( stockDataDailyPersistable.getCandleNum() );
        stockDataDaily.setCandleTimeFrame( stockDataDailyPersistable.getCandleTimeFrame() );
        stockDataDaily.setSymbol( stockDataDailyPersistable.getSymbol() );
        stockDataDaily.setTimestamp( stockDataDailyPersistable.getTimestamp() );
        stockDataDaily.setOpen( stockDataDailyPersistable.getOpen() );
        stockDataDaily.setHigh( stockDataDailyPersistable.getHigh() );
        stockDataDaily.setLow( stockDataDailyPersistable.getLow() );
        stockDataDaily.setClose( stockDataDailyPersistable.getClose() );
        stockDataDaily.setVolume( stockDataDailyPersistable.getVolume() );
        stockDataDaily.setEma8( stockDataDailyPersistable.getEma8() );
        stockDataDaily.setEma13( stockDataDailyPersistable.getEma13() );
        stockDataDaily.setEma21( stockDataDailyPersistable.getEma21() );
        stockDataDaily.setEma34( stockDataDailyPersistable.getEma34() );
        stockDataDaily.setEma55( stockDataDailyPersistable.getEma55() );
        stockDataDaily.setEma89( stockDataDailyPersistable.getEma89() );
        stockDataDaily.setEma200( stockDataDailyPersistable.getEma200() );
        stockDataDaily.setRsi3( stockDataDailyPersistable.getRsi3() );
        stockDataDaily.setRsi14( stockDataDailyPersistable.getRsi14() );
        stockDataDaily.setRsi21( stockDataDailyPersistable.getRsi21() );
        stockDataDaily.setHull21( stockDataDailyPersistable.getHull21() );
        stockDataDaily.setHull55( stockDataDailyPersistable.getHull55() );
        stockDataDaily.setHull89( stockDataDailyPersistable.getHull89() );
        stockDataDaily.setVwap( stockDataDailyPersistable.getVwap() );
        stockDataDaily.setVwma21( stockDataDailyPersistable.getVwma21() );
        stockDataDaily.setRsi14ema9( stockDataDailyPersistable.getRsi14ema9() );
        stockDataDaily.setRsi14ema21( stockDataDailyPersistable.getRsi14ema21() );
        stockDataDaily.setIchimokuCloudTop( stockDataDailyPersistable.getIchimokuCloudTop() );
        stockDataDaily.setIchimokuCloudBottom( stockDataDailyPersistable.getIchimokuCloudBottom() );
        stockDataDaily.setIchimokuCloudBaseLine( stockDataDailyPersistable.getIchimokuCloudBaseLine() );
        stockDataDaily.setIchimokuCloudConversionLine( stockDataDailyPersistable.getIchimokuCloudConversionLine() );
        stockDataDaily.setMacd22107( stockDataDailyPersistable.getMacd22107() );
        stockDataDaily.setMacdSignal22107( stockDataDailyPersistable.getMacdSignal22107() );
        stockDataDaily.setMacdHist22107( stockDataDailyPersistable.getMacdHist22107() );
        stockDataDaily.setMacd26129( stockDataDailyPersistable.getMacd26129() );
        stockDataDaily.setMacdSignal26129( stockDataDailyPersistable.getMacdSignal26129() );
        stockDataDaily.setMacdHist26129( stockDataDailyPersistable.getMacdHist26129() );
        stockDataDaily.setMacd1153( stockDataDailyPersistable.getMacd1153() );
        stockDataDaily.setMacdSignal1153( stockDataDailyPersistable.getMacdSignal1153() );
        stockDataDaily.setMacdHist1153( stockDataDailyPersistable.getMacdHist1153() );
        stockDataDaily.setAtr( stockDataDailyPersistable.getAtr() );
        stockDataDaily.setDiPositive14( stockDataDailyPersistable.getDiPositive14() );
        stockDataDaily.setDinegative14( stockDataDailyPersistable.getDinegative14() );
        stockDataDaily.setAdx14( stockDataDailyPersistable.getAdx14() );
        stockDataDaily.setSupertrend103( stockDataDailyPersistable.getSupertrend103() );
        stockDataDaily.setSupertrend112( stockDataDailyPersistable.getSupertrend112() );
        stockDataDaily.setBbUpper202( stockDataDailyPersistable.getBbUpper202() );
        stockDataDaily.setBbLower202( stockDataDailyPersistable.getBbLower202() );
        stockDataDaily.setBbMiddle202( stockDataDailyPersistable.getBbMiddle202() );
        stockDataDaily.setOpenInterest( stockDataDailyPersistable.getOpenInterest() );
        stockDataDaily.setExchangeSegment( stockDataDailyPersistable.getExchangeSegment() );
        stockDataDaily.setInstrumentType( stockDataDailyPersistable.getInstrumentType() );

        return stockDataDaily;
    }
}
