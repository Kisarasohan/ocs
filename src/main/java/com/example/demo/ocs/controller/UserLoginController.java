package com.example.demo.ocs.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ocs.Dao.CredentionalRepo;

import com.example.demo.ocs.Dao.UserProfileRepo;

import com.example.demo.ocs.bean.CredentialsBean;

import com.example.demo.ocs.bean.ProfileBean;

import com.example.demo.ocs.bean.Status;

@RestController

public class UserLoginController {

 @Autowired

 CredentionalRepo cred;

 @Autowired

 UserProfileRepo prof;

 @PostMapping(value="/users/register",consumes="application/json")

 public Status registerUser(@RequestBody ProfileBean newUser)

 {

 CredentialsBean c = new CredentialsBean();

 c.setLoginstatus(1);

 c.setPassword(newUser.getPassword());

 c.setUsertype("C");

 Random rand = new Random();

 int resRandom = rand.nextInt((999 -100) + 1 )+ 10;

 c.setUserID(newUser.getFirstName().substring(0,2)+Integer.toString(resRandom));

 newUser.setCred(c);

 prof.save(newUser);

 cred.save(c);

 System.out.println(c.getUserID());

 return Status.Registered_successfully;

 }

 @GetMapping("/users/profilelist")

 public List<ProfileBean> profiles(){

 return (List<ProfileBean>) prof.findAll();

 }

 @GetMapping("users/credentialslist")

 public List<CredentialsBean> Cred()

 {

 return cred.findAll();

 }

 @PostMapping(value="/users/login",consumes="application/json")

 public Status loginUser(@RequestBody CredentialsBean user) {

 List<CredentialsBean> users =cred.findAll();

 for(CredentialsBean other : users) {

  if(other.equals(user) && other.getLoginstatus()==0) {

  user.setLoginstatus(1);

  user.setUsertype("C");

  if(user.getUserID().contentEquals("admin123")) {

   user.setUsertype("A");

  }

  else

  {

   user.setUsertype("C");

  }

  cred.save(user);

  return Status.Login_Successfully;

  }

 }

 return Status.User_not_found;

 }

 @PostMapping("/users/logout")

 public Status loguserOut(@RequestBody CredentialsBean user) {

 List<CredentialsBean> users = cred.findAll();

 for(CredentialsBean other : users) {

  if(other.equals(user) && other.getLoginstatus()==1) {

  user.setLoginstatus(0);

  if(user.getUserID().equals("admin123")) {

   user.setUsertype("A");

  }

  else {

   user.setUsertype("C");

  }

  cred.save(user);

  return Status.Logout_Successfully;

  }

 }

 return Status.Failure;

 }

 @PutMapping(path="/users/changepassword",consumes= {"application/json"})

 public Status ChangePassword(@RequestBody CredentialsBean user) {

 cred.save(user);

 return Status.Updated_successfully;

 }

}

























