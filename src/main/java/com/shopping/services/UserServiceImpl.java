package com.shopping.services;

import com.shopping.client.OrderClient;
import com.shopping.db.User;
import com.shopping.db.UserDAO;
import com.shopping.stubs.order.Order;
import com.shopping.stubs.user.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    private static final Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    UserDAO userDAO = new UserDAO();

    @Override
    public void getUserDetails(UserRequest request, StreamObserver<UserResponse> responseObserver) {

        User user = userDAO.getDetails(request.getUsername());

        UserResponse.Builder userReponseBuilder = UserResponse.newBuilder().setId(user.getId()).setUsername(user.getUsername()).setName(user.getName()).setAge(user.getAge()).setGender(Gender.valueOf(user.getGender()));

        List<Order> orders = getOrders(userReponseBuilder);


        userReponseBuilder.setNoOfOrders(orders.size());
        UserResponse userResponse = userReponseBuilder.build();
        responseObserver.onNext(userResponse);
        responseObserver.onCompleted();

    }

    private List<Order> getOrders(UserResponse.Builder userReponseBuilder) {
        logger.info("creating a channel that calling order client");
        ManagedChannel channel = ManagedChannelBuilder.forTarget("localhost:50052").usePlaintext().build();

        OrderClient orderClient = new OrderClient(channel);
        List<Order> orders = orderClient.getOrders(userReponseBuilder.getId());
        logger.info("ORDERS.SIZE()" + orders.size());
        userReponseBuilder.setNoOfOrders(orders.size());

        try {
            channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            logger.log(Level.SEVERE, "server has interrupted", e);
        }
        return orders;
    }

    @Override
    public void saveUser(UserRequestSave request, StreamObserver<UserResponseSave> responseObserver) {

        logger.info("Starting inserting");
        User user = new User();
        user.setId(request.getId());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setName(request.getName());
        user.setGender(request.getGender());
        user.setAge(request.getAge());

        try {
            userDAO.insert(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        UserResponseSave userResponseSave = UserResponseSave
                .newBuilder()
                .setUsername(user.getUsername())
                .setPassword(user.getPassword())
                .setName(user.getUsername())
                .setGender(user.getGender())
                .setAge(user.getAge()).build();

        responseObserver.onNext(userResponseSave);
        responseObserver.onCompleted();
    }
}
