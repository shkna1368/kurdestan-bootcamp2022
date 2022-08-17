package com.kurdestanbootcamp.postemployeeservice.employee_client.grpc;


import com.kurdestanbootcamp.postemployeeservice.EmployeeRequest;
import com.kurdestanbootcamp.postemployeeservice.EmployeeResponse;
import com.kurdestanbootcamp.postemployeeservice.GEmployeeServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
public class EmpGrpcService {

    @GrpcClient("myService")
    private GEmployeeServiceGrpc.GEmployeeServiceBlockingStub myServiceStub;

    public EmployeeResponse getEmployee(Long id ) {


        return myServiceStub.getEmployee(EmployeeRequest.newBuilder()
                .setId(id)

                .build());
    }

}
