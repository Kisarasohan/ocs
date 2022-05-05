package com.example.demo.ocs.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name="OCS_TBL_Appointments")
@Data
public class AppointmentsBean {
	@Id
	private String appointmentId;
	private String doctorId;
	private String patientId;
	private String  appointmentDate ;
	private String appointmentTime ;
}