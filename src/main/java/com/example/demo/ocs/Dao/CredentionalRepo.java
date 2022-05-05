package com.example.demo.ocs.Dao;



import org.springframework.boot.autoconfigure.ldap.embedded.EmbeddedLdapProperties.Credential;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ocs.bean.CredentialsBean;

public interface CredentionalRepo extends JpaRepository<CredentialsBean, String> {

}







