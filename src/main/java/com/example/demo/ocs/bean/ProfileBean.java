package com.example.demo.ocs.bean;
import javax.persistence.Entity;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="OCS_TBL_User_Profile")
@Data
public class ProfileBean {
	@Id
	private String userId;
	private String firstName;
	private String lastName;
	private Date datofBirth;
	private String gender;
	private String street;
	private String location;
	private String city;
	private String state;
	private String pincode;
	private String mobileNumber;
	private String emailId;
	private String password;

}
