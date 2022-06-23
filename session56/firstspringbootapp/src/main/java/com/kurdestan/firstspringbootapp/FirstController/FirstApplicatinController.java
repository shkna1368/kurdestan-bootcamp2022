package com.kurdestan.firstspringbootapp.FirstController;

import com.kurdestan.firstspringbootapp.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/first-application-controller")
public class FirstApplicatinController {

@GetMapping("/hi")
    public ResponseEntity<String> sayHi(){
    String hi="Slaw bo  kurdestan";
    return ResponseEntity.ok(hi);

}


@GetMapping("/hi/{name}")
    public ResponseEntity<String> sayHiToUser(@PathVariable String name){
    String hi="Slaw bo  kurdestan " +name;
    return ResponseEntity.ok(hi);

}

@GetMapping("/sum/{number1}/{number2}")
    public ResponseEntity<Long> sum(@PathVariable Long number1,@PathVariable Long number2){
    Long result=number1+number2;
    return ResponseEntity.ok(result);

}

@GetMapping("/sum2")
    public ResponseEntity<Long> sum3(@RequestParam("num1") Long number1,@RequestParam("num2") Long number2){
    Long result=number1+number2;
    return ResponseEntity.ok(result);

}

@PostMapping("/uppercase")

    public ResponseEntity<String> uppsercaseNameAndFamily(@RequestBody Map<String,String> data){
    String firstName=data.get("firstName").toUpperCase();
    String lastName=data.get("lastName").toUpperCase();


    String fullname=firstName+""+lastName;

    return ResponseEntity.ok(fullname);


}

@PostMapping("/uppercase2")

    public ResponseEntity<String> uppsercaseNameAndFamilyWithModel(@RequestBody User user){
    String firstName=user.getFirstName().toUpperCase();
    String lastName= user.getLastName().toUpperCase();


    String fullname=firstName+""+lastName;

    return ResponseEntity.ok(fullname);


}




}
