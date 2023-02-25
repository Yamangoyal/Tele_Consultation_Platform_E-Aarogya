package com.shield.eaarogya.Controller;

import com.shield.eaarogya.DTO.PatientDetails;
import com.shield.eaarogya.Entity.Patient;
import com.shield.eaarogya.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    // -------------------------------- Get List of all Patients --------------------------------
    @GetMapping("/getPatients")
    public List<Patient> getPatients() {
        return this.patientService.getPatient();
    }


    // -------------------------------- Register Patient --------------------------------------
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Patient user) {
        patientService.register(user);
        return new ResponseEntity<>("Registration successful", HttpStatus.OK);
    }

    // ---------------------------------Patient Login --------------------------------------------
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String email, @RequestParam String password) {
        patientService.login(email, password);
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }
}
