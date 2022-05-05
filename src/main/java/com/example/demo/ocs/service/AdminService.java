package com.example.demo.ocs.service;

import java.util.ArrayList;

import com.example.demo.ocs.bean.DoctorBean;

public interface AdminService {

 DoctorBean addDoctor(DoctorBean doctorbean);

 DoctorBean modifyDoctor(DoctorBean doctorbean);

 int removeDoctor(String doctorID);

 ArrayList<DoctorBean> viewByAllDoctors();

 DoctorBean viewByDoctorID(String doctorId);

}













