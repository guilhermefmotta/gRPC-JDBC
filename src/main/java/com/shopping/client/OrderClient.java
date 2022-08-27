package com.shopping.client;

import com.shopping.services.OrderServiceImpl;
import com.shopping.stubs.order.Order;
import com.shopping.stubs.order.OrderRequest;
import com.shopping.stubs.order.OrderResponse;
import com.shopping.stubs.order.OrderServiceGrpc;
import io.grpc.Channel;

import java.util.List;
import java.util.logging.Logger;

public class OrderClient {

    private static final Logger logger = Logger.getLogger(OrderClient.class.getName());
    private final OrderServiceGrpc.OrderServiceBlockingStub orderServiceBlockingStub;

    public OrderClient(Channel channel) {
        orderServiceBlockingStub = OrderServiceGrpc.newBlockingStub(channel);
    }

    public List<Order> getOrders(int userId) {
        logger.info("Order client calling the order service method");
        OrderRequest orderRequest = OrderRequest.newBuilder().setUserId(userId).build();
        OrderResponse orderResponse = orderServiceBlockingStub.getOrdersForUse(orderRequest);
        return orderResponse.getOrderList();
    }

}
