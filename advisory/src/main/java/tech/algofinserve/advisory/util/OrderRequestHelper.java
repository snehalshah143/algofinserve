package tech.algofinserve.advisory.util;

import com.angelbroking.smartapi.models.OrderParams;
import com.angelbroking.smartapi.utils.Constants;
import org.springframework.stereotype.Component;
import tech.algofinserve.advisory.model.domain.OrderRequest;

@Component
public class OrderRequestHelper {

   public OrderParams buildOrderParams(OrderRequest orderRequest){
        OrderParams orderParams = new OrderParams();
        if (orderRequest.getExchangeOrderId() != null) {

             orderParams.orderid=orderRequest.getExchangeOrderId();

        }
        orderParams.variety = Constants.VARIETY_NORMAL;
        orderParams.quantity = orderRequest.getQuantity();
        orderParams.symboltoken = orderRequest.getRecommendation().getTicker().getToken();
        orderParams.exchange = orderRequest.getRecommendation().getExchangeSegment().value();

        orderParams.ordertype = orderRequest.getOrdertype()==null? Constants.ORDER_TYPE_LIMIT:orderRequest.getOrdertype();
    //    orderParams.tradingsymbol = "SBIN-EQ";
        orderParams.tradingsymbol = orderRequest.getRecommendation().getTicker().getStockSymbolExch();
        orderParams.producttype = Constants.PRODUCT_DELIVERY;
        orderParams.duration = Constants.DURATION_DAY;
        orderParams.transactiontype = orderRequest.getBuySell()==null?
        orderRequest.getRecommendation().getBuySell().name():orderRequest.getBuySell().name();
        orderParams.price = orderRequest.getEntryPrice()==null?
                Double.valueOf(orderRequest.getRecommendation().getEntryPrice())
                :orderRequest.getEntryPrice();
        orderParams.squareoff = "0";
        orderParams.stoploss = "0";
        return orderParams;
    }
}
