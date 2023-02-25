package com.shield.eaarogya.Controller;

import com.shield.eaarogya.DTO.DoctorDetails;
import com.shield.eaarogya.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // ----------------------------------------- Register a Doctor -----------------------------------------
    @PostMapping("/registerDoctor")
    public DoctorDetails registerDoctor(@RequestBody DoctorDetails doctorDetails) {
        return doctorService.addDoctor(doctorDetails);
    }

    //-------------------------------------------Doctor Login-----------------------------------------------
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        doctorService.login(email, password);
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }

    // ------------------------------------- Get List of all Doctors ------------------------------------------
    @GetMapping("/getAllDoctors")
    public List<DoctorDetails> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

}
