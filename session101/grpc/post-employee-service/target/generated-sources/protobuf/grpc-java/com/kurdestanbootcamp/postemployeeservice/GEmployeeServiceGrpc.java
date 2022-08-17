package com.kurdestanbootcamp.postemployeeservice;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.22.1)",
    comments = "Source: employee-service.proto")
public final class GEmployeeServiceGrpc {

  private GEmployeeServiceGrpc() {}

  public static final String SERVICE_NAME = "GEmployeeService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.kurdestanbootcamp.postemployeeservice.EmployeeRequest,
      com.kurdestanbootcamp.postemployeeservice.EmployeeResponse> getGetEmployeeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getEmployee",
      requestType = com.kurdestanbootcamp.postemployeeservice.EmployeeRequest.class,
      responseType = com.kurdestanbootcamp.postemployeeservice.EmployeeResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.kurdestanbootcamp.postemployeeservice.EmployeeRequest,
      com.kurdestanbootcamp.postemployeeservice.EmployeeResponse> getGetEmployeeMethod() {
    io.grpc.MethodDescriptor<com.kurdestanbootcamp.postemployeeservice.EmployeeRequest, com.kurdestanbootcamp.postemployeeservice.EmployeeResponse> getGetEmployeeMethod;
    if ((getGetEmployeeMethod = GEmployeeServiceGrpc.getGetEmployeeMethod) == null) {
      synchronized (GEmployeeServiceGrpc.class) {
        if ((getGetEmployeeMethod = GEmployeeServiceGrpc.getGetEmployeeMethod) == null) {
          GEmployeeServiceGrpc.getGetEmployeeMethod = getGetEmployeeMethod = 
              io.grpc.MethodDescriptor.<com.kurdestanbootcamp.postemployeeservice.EmployeeRequest, com.kurdestanbootcamp.postemployeeservice.EmployeeResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "GEmployeeService", "getEmployee"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.kurdestanbootcamp.postemployeeservice.EmployeeRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.kurdestanbootcamp.postemployeeservice.EmployeeResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new GEmployeeServiceMethodDescriptorSupplier("getEmployee"))
                  .build();
          }
        }
     }
     return getGetEmployeeMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GEmployeeServiceStub newStub(io.grpc.Channel channel) {
    return new GEmployeeServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GEmployeeServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new GEmployeeServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GEmployeeServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new GEmployeeServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class GEmployeeServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getEmployee(com.kurdestanbootcamp.postemployeeservice.EmployeeRequest request,
        io.grpc.stub.StreamObserver<com.kurdestanbootcamp.postemployeeservice.EmployeeResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getGetEmployeeMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetEmployeeMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                com.kurdestanbootcamp.postemployeeservice.EmployeeRequest,
                com.kurdestanbootcamp.postemployeeservice.EmployeeResponse>(
                  this, METHODID_GET_EMPLOYEE)))
          .build();
    }
  }

  /**
   */
  public static final class GEmployeeServiceStub extends io.grpc.stub.AbstractStub<GEmployeeServiceStub> {
    private GEmployeeServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GEmployeeServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GEmployeeServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GEmployeeServiceStub(channel, callOptions);
    }

    /**
     */
    public void getEmployee(com.kurdestanbootcamp.postemployeeservice.EmployeeRequest request,
        io.grpc.stub.StreamObserver<com.kurdestanbootcamp.postemployeeservice.EmployeeResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetEmployeeMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class GEmployeeServiceBlockingStub extends io.grpc.stub.AbstractStub<GEmployeeServiceBlockingStub> {
    private GEmployeeServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GEmployeeServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GEmployeeServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GEmployeeServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.kurdestanbootcamp.postemployeeservice.EmployeeResponse getEmployee(com.kurdestanbootcamp.postemployeeservice.EmployeeRequest request) {
      return blockingUnaryCall(
          getChannel(), getGetEmployeeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class GEmployeeServiceFutureStub extends io.grpc.stub.AbstractStub<GEmployeeServiceFutureStub> {
    private GEmployeeServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private GEmployeeServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GEmployeeServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new GEmployeeServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.kurdestanbootcamp.postemployeeservice.EmployeeResponse> getEmployee(
        com.kurdestanbootcamp.postemployeeservice.EmployeeRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getGetEmployeeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_EMPLOYEE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GEmployeeServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GEmployeeServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_EMPLOYEE:
          serviceImpl.getEmployee((com.kurdestanbootcamp.postemployeeservice.EmployeeRequest) request,
              (io.grpc.stub.StreamObserver<com.kurdestanbootcamp.postemployeeservice.EmployeeResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class GEmployeeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    GEmployeeServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.kurdestanbootcamp.postemployeeservice.EmployeeService.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("GEmployeeService");
    }
  }

  private static final class GEmployeeServiceFileDescriptorSupplier
      extends GEmployeeServiceBaseDescriptorSupplier {
    GEmployeeServiceFileDescriptorSupplier() {}
  }

  private static final class GEmployeeServiceMethodDescriptorSupplier
      extends GEmployeeServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    GEmployeeServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GEmployeeServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new GEmployeeServiceFileDescriptorSupplier())
              .addMethod(getGetEmployeeMethod())
              .build();
        }
      }
    }
    return result;
  }
}
