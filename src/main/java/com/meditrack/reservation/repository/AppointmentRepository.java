package com.meditrack.reservation.repository;

import com.meditrack.reservation.model.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("SELECT d.id, COUNT(a) FROM Appointment a JOIN a.doctor d GROUP BY d.id")
    List<Object[]> countAppointmentsPerDoctor();

    @Query("SELECT DATE(a.date), COUNT(a) FROM Appointment a GROUP BY DATE(a.date)")
    List<Object[]> countAppointmentsOverTime();

}
