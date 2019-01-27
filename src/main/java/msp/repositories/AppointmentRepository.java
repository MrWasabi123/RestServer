package msp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import msp.model.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}

