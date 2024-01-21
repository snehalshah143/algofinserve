package tech.algofinserve.advisory.service;

import com.angelbroking.smartapi.SmartConnect;
import com.angelbroking.smartapi.http.exceptions.SmartAPIException;
import com.angelbroking.smartapi.models.Order;
import com.angelbroking.smartapi.models.OrderParams;
import com.angelbroking.smartapi.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import tech.algofinserve.advisory.model.domain.OrderRequest;
import tech.algofinserve.advisory.util.OrderRequestHelper;

import java.io.IOException;
import java.util.List;

public class AngelExecutionServiceImpl extends AngelExecutionService{

    @Autowired
    OrderRequestHelper orderRequestHelper;
    public Order placeOrder(SmartConnect smartConnect, OrderRequest orderRequest) throws SmartAPIException, IOException {

        OrderParams orderParams = orderRequestHelper.buildOrderParams(orderRequest);

        Order order = smartConnect.placeOrder(orderParams, Constants.VARIETY_NORMAL);
        return order;
    }

    /** Modify order. */
    public Order modifyOrder(SmartConnect smartConnect,OrderRequest orderRequest) throws SmartAPIException, IOException {
        // Modify order request will return the order model which will contain order_id.
        Order order = null;
        OrderParams orderParams = orderRequestHelper.buildOrderParams(orderRequest);
if(orderParams.orderid!=null){
     order = smartConnect.modifyOrder(orderParams.orderid, orderParams, Constants.VARIETY_NORMAL);
}
   return order;
    }

    /** Cancel order */
    public Order cancelOrder(SmartConnect smartConnect,Order order) throws SmartAPIException, IOException {
        // Cancel order will return the order model which will have orderId.

        if(order.orderId !=null) {
            Order o = smartConnect.cancelOrder(order.orderId, Constants.VARIETY_NORMAL);
        }
        return order;
    }


}
