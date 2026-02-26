package com.hotelcalifornia.hotelcalifornia.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelcalifornia.hotelcalifornia.domain.model.entity.Room;

@Repository
public interface IRoom extends JpaRepository<Room, Integer>{

}
