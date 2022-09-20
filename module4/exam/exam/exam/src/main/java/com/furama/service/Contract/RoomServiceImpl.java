package com.furama.service.Contract;

import com.furama.model.Contract.Room;
import com.furama.repository.Contract.RoomRepository;
import com.furama.service.IGeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomServiceImpl implements IGeneralService<Room> {
    @Autowired
    private RoomRepository customerTypeRepository;
    @Override
    public List<Room> findAll() {
        return customerTypeRepository.findAll();
    }

    @Override
    public void save(Room customerType) {
        customerTypeRepository.save(customerType);
    }
    public Optional<Room> findById(String id){
        return customerTypeRepository.findById(id);
    }
}
