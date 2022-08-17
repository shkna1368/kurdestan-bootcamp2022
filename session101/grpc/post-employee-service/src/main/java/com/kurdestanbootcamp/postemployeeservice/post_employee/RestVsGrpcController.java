package com.kurdestanbootcamp.postemployeeservice.post_employee;


import com.kurdestanbootcamp.postemployeeservice.employee_client.EmployeeClient;
import com.kurdestanbootcamp.postemployeeservice.employee_client.grpc.EmpGrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restVSgrpc")
public class RestVsGrpcController {

    @Autowired
    EmployeeClient employeeClient;

 @Autowired
 EmpGrpcService empGrpcService;



    @GetMapping("/grpc/employee/v1/{id}")
    public ResponseEntity<Void> getByIdWithGRPC(@PathVariable Long id ){


empGrpcService.getEmployee(id);

/*        EmployeeResponse employeeResponse = stub.getEmployee(EmployeeRequest.newBuilder()
                .setId(id)

                .build());*/


        return ResponseEntity.ok().build();
    }

    @GetMapping("/rest/employee/v1/{id}")
    public ResponseEntity<Void> getByIdWithRest(@PathVariable Long id ){

        employeeClient.getEmployee(id);
        return ResponseEntity.ok().build();
    }

}
