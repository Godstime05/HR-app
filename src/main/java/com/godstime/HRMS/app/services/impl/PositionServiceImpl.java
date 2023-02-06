package com.godstime.HRMS.app.services.impl;

import com.godstime.HRMS.app.entities.Employee;
import com.godstime.HRMS.app.entities.Position;
import com.godstime.HRMS.app.exceptions.PositionCreationFailedException;
import com.godstime.HRMS.app.exceptions.PositionDeletionFailedException;
import com.godstime.HRMS.app.exceptions.PositionNotFoundException;
import com.godstime.HRMS.app.repository.PositionRepository;
import com.godstime.HRMS.app.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }



    @Override
    public Position createPosition(Position position) {
        if(position.getId() != null){
            throw new PositionCreationFailedException("Position should not contain an ID when creating a new position.");
        }
        try {
            return positionRepository.save(position);
        } catch (Exception e) {
            throw new PositionCreationFailedException("Failed to create new position.");
        }
    }

    @Override
    public Position updatePosition(Long positionId, Position position) {
        if(!existsById(positionId)){
            throw new PositionNotFoundException("Position with ID "+positionId+" not found.");
        }
        position.setId(positionId);
        return positionRepository.save(position);
    }



    @Override
    public Position findById(Long id) throws PositionNotFoundException {
        return positionRepository.findById(id)
                .orElseThrow(() -> new PositionNotFoundException("Position with id " + id + " not found"));

    }

    @Override
    public Position findByFirstName(String firstName) throws PositionNotFoundException {
        Position position = positionRepository.findByFirstName(firstName);
        if (position == null) {
            throw new PositionNotFoundException("Position with name " + firstName + " not found");
        }
        return position;
    }

    @Override
    public List<Position> findByDepartment(Long departmentId) throws PositionNotFoundException {
        List<Position> positions = positionRepository.findByDepartment(departmentId);
        if (positions.isEmpty()) {
            throw new PositionNotFoundException("Position with department id " + departmentId + " not found");
        }
        return positions;
    }

    @Override
    public List<Position> findByEmployee(Employee employeeId) throws PositionNotFoundException {
        List<Position> positions = positionRepository.findByEmployee(employeeId);
        if (positions.isEmpty()) {
            throw new PositionNotFoundException("Position with employee id " + employeeId + " not found");
        }
        return positions;

    }

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

   // @Override
//    public List<Position> findByEmployeeCount() {
//        return positionRepository.findByEmployeeCount();
//    }

//    @Override
//    public List<Position> findByEmployeeCount(Long departmentId) {
//        return positionRepository.findByEmployeeCount(departmentId);
//
//    }

    @Override
    public Position getPositionById(Long positionId) {
        return positionRepository.findById(positionId)
                .orElseThrow(() -> new PositionNotFoundException("Position with ID "+positionId+" not found."));
    }

    @Override
    public void deletePosition(Long positionId) {
        if(!existsById(positionId)){
            throw new PositionNotFoundException("Position with ID "+positionId+" not found.");
        }
        try {
            positionRepository.deleteById(positionId);
        } catch (Exception e) {
            throw new PositionDeletionFailedException("Failed to delete position with ID "+positionId+".");
        }
    }

    @Override
    public boolean existsById(Long id) {
        return positionRepository.existsById(id);
    }
//////////////////////////////////////////////////////////////////////////////

}