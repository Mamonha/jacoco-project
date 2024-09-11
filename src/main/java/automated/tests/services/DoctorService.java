package automated.tests.services;

import automated.tests.entities.Doctor;
import automated.tests.exceptions.ResourceNotFoundException;
import automated.tests.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List <Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Optional<Doctor> getDoctorById(Long id) {
        return doctorRepository.findById(id);
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long id, Doctor doctorDetails) {
        return doctorRepository.findById(id)
                .map(doctor -> {
                    doctor.setName(doctorDetails.getName());
                    doctor.setSpecialty(doctorDetails.getSpecialty());
                    return doctorRepository.save(doctor);
                }).orElseThrow(() -> new ResourceNotFoundException("Doctor not found with id " + id));
    }

    public void deleteDoctor(Long id) {
        doctorRepository.findById(id)
                .ifPresent(doctorRepository::delete);
    }
}
