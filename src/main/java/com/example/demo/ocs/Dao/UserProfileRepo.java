package com.example.demo.ocs.Dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.ocs.bean.ProfileBean;

public interface UserProfileRepo extends CrudRepository<ProfileBean, String>{

}