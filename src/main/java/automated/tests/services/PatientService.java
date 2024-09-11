package automated.tests.services;

import automated.tests.entities.Patient;
import automated.tests.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public void deletePatient(Long id) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        patient.setName("Anonymous");
        patient.setCpf(null);
        patient.setAnonymous(true);
        patientRepository.save(patient);
    }

    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow();
    }

    public Patient updatePatient(Long id, Patient newPatient) {
        Patient patient = patientRepository.findById(id).orElseThrow();
        patient.setName(newPatient.getName());
        patient.setDoctor(newPatient.getDoctor());
        return patientRepository.save(patient);
    }
}
