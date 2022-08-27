// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: order.proto

package com.shopping.stubs.order;

public final class OrderOuterClass {
  private OrderOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_OrderRequest_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_OrderRequest_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_OrderResponse_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_OrderResponse_fieldAccessorTable;
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Order_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Order_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013order.proto\032\037google/protobuf/timestamp" +
      ".proto\"\037\n\014OrderRequest\022\017\n\007user_id\030\001 \001(\005\"" +
      "&\n\rOrderResponse\022\025\n\005order\030\001 \003(\0132\006.Order\"" +
      "\205\001\n\005Order\022\017\n\007user_id\030\001 \001(\005\022\020\n\010order_id\030\002" +
      " \001(\005\022\023\n\013no_of_items\030\003 \001(\005\022\024\n\014total_amoun" +
      "t\030\004 \001(\001\022.\n\norder_date\030\005 \001(\0132\032.google.pro" +
      "tobuf.Timestamp2@\n\014OrderService\0220\n\017getOr" +
      "dersForUse\022\r.OrderRequest\032\016.OrderRespons" +
      "eB\034\n\030com.shopping.stubs.orderP\001b\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.TimestampProto.getDescriptor(),
        });
    internal_static_OrderRequest_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_OrderRequest_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_OrderRequest_descriptor,
        new java.lang.String[] { "UserId", });
    internal_static_OrderResponse_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_OrderResponse_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_OrderResponse_descriptor,
        new java.lang.String[] { "Order", });
    internal_static_Order_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_Order_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Order_descriptor,
        new java.lang.String[] { "UserId", "OrderId", "NoOfItems", "TotalAmount", "OrderDate", });
    com.google.protobuf.TimestampProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
