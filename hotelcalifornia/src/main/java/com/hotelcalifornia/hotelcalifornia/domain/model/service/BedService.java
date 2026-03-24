package com.hotelcalifornia.hotelcalifornia.domain.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.hotelcalifornia.hotelcalifornia.domain.model.entity.Bed;
import com.hotelcalifornia.hotelcalifornia.infraestructure.repository.IBeed;
import com.hotelcalifornia.hotelcalifornia.utils.messeg.Messege404;

@Service
public class BedService {
    @Autowired
    IBeed repositoryBeed;

    public Bed saveBed(Bed data){
        if(data.getId() == null || data.getType() == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Messege404.NOT_FOUND.getText());
        }
        return this.repositoryBeed.save(data);
    }

    public List<Bed> serarchBeds(){
        return this.repositoryBeed.findAll();
    }

    public Bed searchBedById(Integer id){
        Optional<Bed> searchByIdOptional =  this.repositoryBeed.findById(id);
        if(!searchByIdOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Messege404.NOT_FOUND.getText());
        }
        return searchByIdOptional.get();
    }

    public void deleteByid(Integer id){
        Optional<Bed> deleteByIdOptional = this.repositoryBeed.findById(id);
        if(!deleteByIdOptional.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Messege404.NOT_FOUND.getText());
        }
        this.repositoryBeed.deleteById(id);
    }
    public Bed updateTypeBed(Integer id, Bed data){
        Optional<Bed> searchByIdOptional  = repositoryBeed.findById(id);
        if(!searchByIdOptional.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, Messege404.NOT_FOUND.getText());
        }
        Bed bedToUpdate = searchByIdOptional.get();
        if(data.getType() != null){
            bedToUpdate.setType(data.getType());
        }
        return this.repositoryBeed.save(bedToUpdate);
    }


}
