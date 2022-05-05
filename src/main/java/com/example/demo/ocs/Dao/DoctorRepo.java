package com.example.demo.ocs.Dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ocs.bean.CredentialsBean;
public interface DoctorRepo extends  JpaRepository<CredentialsBean, String>{

}
