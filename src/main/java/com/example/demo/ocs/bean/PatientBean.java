package com.example.demo.ocs.bean;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

import lombok.Data;

@Entity
@Table(name="OCS_TBL_Patient")
@Data
public class PatientBean {
	@Id
	private String patientID;
	private String userID;
	private Date appointmentDate;
	private String ailmentType;
	private String ailmentDetails;
	private String diagnosisHistory;

}
