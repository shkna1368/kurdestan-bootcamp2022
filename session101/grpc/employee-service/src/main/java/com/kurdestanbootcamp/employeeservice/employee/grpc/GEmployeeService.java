package com.kurdestanbootcamp.employeeservice.employee.grpc;

import com.kurdestanbootcamp.employeeservice.EmployeeRequest;
import com.kurdestanbootcamp.employeeservice.EmployeeResponse;
import com.kurdestanbootcamp.employeeservice.GEmployeeServiceGrpc;
import com.kurdestanbootcamp.employeeservice.employee.Employee;
import com.kurdestanbootcamp.employeeservice.employee.IEmployeeService;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class GEmployeeService extends GEmployeeServiceGrpc.GEmployeeServiceImplBase {
@Autowired
IEmployeeService employeeService;


    @Override
    public void getEmployee(EmployeeRequest request,
                            StreamObserver<EmployeeResponse> responseObserver) {


      Employee employee= employeeService.getById(request.getId());
        //call repository to load the data from database
        //we have added static data for example
        EmployeeResponse empResp = EmployeeResponse
                .newBuilder()
                .setId(employee.getId())
                .setName(employee.getName())
                .setBirthDay(employee.getBirthDay().getTime())
                .setChildCount(employee.getChildCount())
                .setIsMarried(employee.getIsMarried())
                .setFamily(employee.getFamily())
                .setNationalCode(employee.getNationalCode())
                .build();

        //set the response object
        responseObserver.onNext(empResp);

        //mark process is completed
        responseObserver.onCompleted();
    }
}
