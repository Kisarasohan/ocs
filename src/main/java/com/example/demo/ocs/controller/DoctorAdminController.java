package com.example.demo.ocs.controller;



import java.util.ArrayList;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ocs.bean.DoctorBean;

import com.example.demo.ocs.service.AdminService;

@RestController

public class DoctorAdminController {

@Autowired

AdminService ad;

@PostMapping(value="/doctor/save",consumes="application/json")

public String adddoctor(@RequestBody DoctorBean doctor) {

 Random rand=new Random();

 int resRandom = rand.nextInt((999-100)+1)+10;

 doctor.setDoctorID(doctor.getDoctorname().substring(0,2)+Integer.toString(resRandom));

 ad.addDoctor(doctor);

 return "added Successfully";

}

@GetMapping(value="/doctor/viewall")

public ArrayList<DoctorBean> viewall(){

 if(ad.viewByAllDoctors().isEmpty())

 {

 System.out.println("No Doctors Available");

 }

 return ad.viewByAllDoctors();

}

@GetMapping(value="/doctor/viewById/{doctorID}")

public DoctorBean viewById(@PathVariable("doctorID") String doctorID)

{

 if(ad.viewByDoctorID(doctorID)==null) {

 System.out.println("No flight is available");

 }

 return ad.viewByDoctorID(doctorID);

}

@DeleteMapping(value="/doctor/delete/{doctorID}")

public String deletedoctor(@PathVariable("doctorID") String doctorID) {

 ad.removeDoctor(doctorID);

 return "Deleted Successfully";

}

@PutMapping(value="/doctor/update")

public DoctorBean updateDoctor(@RequestBody DoctorBean doctor)

{

 return ad.modifyDoctor(doctor);

}

}





























