package com.example.demo.ocs.service;



import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.ocs.Dao.DoctorRepo;

import com.example.demo.ocs.bean.DoctorBean;

@Service

public class AdminServiceImpl implements AdminService {

 @Autowired

 private DoctorRepo dr;

 @Override

 public DoctorBean addDoctor(DoctorBean doctorbean) {

 return dr.save(doctorbean);

 }

 @Override

 public DoctorBean modifyDoctor(DoctorBean doctorbean) {

 return dr.save(doctorbean);

 }

 @Override

 public int removeDoctor(String doctorID) {

 if(dr.existsById(doctorID)) {

  dr.deleteById(doctorID);

  return 1;

 }

 else {

  return 0;

 }

 }

 @Override

 public ArrayList<DoctorBean> viewByAllDoctors() {

 return (ArrayList<DoctorBean>) dr.findAll();

 }

 @Override

 public DoctorBean viewByDoctorID(String doctorId) {

 return dr.findByDoctorID(doctorId);

 }

}























