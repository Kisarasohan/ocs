package com.example.demo.ocs.bean;

import java.util.Objects;

import javax.persistence.CascadeType;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.OneToOne;

import javax.persistence.Table;

import lombok.Data;

import lombok.NoArgsConstructor;

@Entity

@Table(name="OCS_TBL_User_Credentials")

@Data

@NoArgsConstructor

public class CredentialsBean {

 @Id

 private String userID;

 private String password;

 private String usertype;

 private int loginstatus;

 @Override

 public boolean equals(Object o) {

   if (this == o) return true;

   if (!(o instanceof CredentialsBean)) return false;

   CredentialsBean user = (CredentialsBean) o;

   return Objects.equals(userID, user.userID) &&

       Objects.equals(password, user.password);

 }

 @Override

 public int hashCode() {

   return Objects.hash(userID, password, usertype,loginstatus

            );

 }

 @OneToOne(mappedBy = "cred", cascade = CascadeType.ALL)

 private ProfileBean prof;

}





























