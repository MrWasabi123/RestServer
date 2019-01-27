package msp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import msp.model.Appointment;
import msp.repositories.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService{
	
	private AppointmentRepository appointmentRepository;
	
	public AppointmentServiceImpl(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}
	
	@Override
	public List<Appointment> findAllAppointments(){
		return appointmentRepository.findAll();
	}

	@Override
	public List<Appointment> findById(long id, int size) {
		String stringId = ""+id;
		List<Appointment> appointments = new ArrayList<>();
		for(Appointment a: appointmentRepository.findAll()) {
			String appointmentIdString = ""+a.getId();
			if(appointmentIdString.contains(stringId) && appointments.size()<=size) {
				appointments.add(a);
			}
			if(appointments.size()>size) {
				break;
			}
		}
		return appointments;
	}


	public void save(Appointment appointment) {
		appointmentRepository.save(appointment);
	}

	@Override
	public Appointment updateAppointment(Appointment appointment, long id) {
		Appointment updateThis = appointmentRepository.findById(id).get();
		updateThis.setAccepted(appointment.getAccepted());
		save(updateThis);
		return updateThis;
	}

}
