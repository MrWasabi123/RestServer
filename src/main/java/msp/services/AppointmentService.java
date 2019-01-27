package msp.services;

import java.util.List;

import msp.model.Appointment;

public interface AppointmentService {

	List<Appointment> findAllAppointments();

	List<Appointment> findById(long id, int size);
	
	void updateAppointment(Appointment appointment);

}
