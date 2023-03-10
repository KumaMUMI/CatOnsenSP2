package com.example.catonsensp2.service;

import com.example.catonsensp2.models.MassageAppointModel;
import com.example.catonsensp2.repositories.MassageAppointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MassageAppointService {

    @Autowired
    private MassageAppointRepository massageAppointRepository;


    public List<MassageAppointModel> findAllMassageAppoint(){
        return this.massageAppointRepository.findAll();
    }

    public Optional<MassageAppointModel> findMassageAppointByID(Long id){
        return this.massageAppointRepository.findById(id);
    }

    public List<MassageAppointModel> findByDate(Date date){
        List<MassageAppointModel> appointDate = massageAppointRepository.findMassageAppointByDate(date);

        return appointDate;
    }

    public MassageAppointModel saveMassageAppoint(MassageAppointModel appointment){
        return this.massageAppointRepository.save(appointment);
    }

    public Optional<MassageAppointModel> updateMassageAppoint(Long id, MassageAppointModel newAppointment){
        return this.massageAppointRepository.findById(id).map(appointment -> {
            appointment.setRoom(newAppointment.getRoom());
            appointment.setDate(newAppointment.getDate());
            return massageAppointRepository.save(appointment);
        });
    }

    public void deleteByID(Long id){
        this.massageAppointRepository.deleteById(id);
    }

}
