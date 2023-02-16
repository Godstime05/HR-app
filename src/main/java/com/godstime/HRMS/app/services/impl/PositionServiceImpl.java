package com.godstime.HRMS.app.services.impl;

import com.godstime.HRMS.app.entities.Employee;
import com.godstime.HRMS.app.entities.Position;
import com.godstime.HRMS.app.exceptions.PositionCreationFailedException;
import com.godstime.HRMS.app.exceptions.PositionDeletionFailedException;
import com.godstime.HRMS.app.exceptions.PositionNotFoundException;
import com.godstime.HRMS.app.repository.JobPositionRepo;
import com.godstime.HRMS.app.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final JobPositionRepo jobPositionRepo;

    @Autowired
    public PositionServiceImpl(JobPositionRepo jobPositionRepo) {
        this.jobPositionRepo = jobPositionRepo;
    }



    @Override
    public Position createPosition(Position position) {
        if(position.getId() != null){
            throw new PositionCreationFailedException("Position should not contain an ID when creating a new position.");
        }
        try {
            return jobPositionRepo.save(position);
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
        return jobPositionRepo.save(position);
    }



    @Override
    public Position findById(Long id) throws PositionNotFoundException {
        return jobPositionRepo.findById(id)
                .orElseThrow(() -> new PositionNotFoundException("Position with id " + id + " not found"));

    }

    @Override
    public Position findByFirstName(String firstName) throws PositionNotFoundException {
        Position position = jobPositionRepo.findByFirstName(firstName);
        if (position == null) {
            throw new PositionNotFoundException("Position with name " + firstName + " not found");
        }
        return position;
    }

    @Override
    public List<Position> findByDepartment(Long departmentId) throws PositionNotFoundException {
        List<Position> positions = jobPositionRepo.findByDepartment(departmentId);
        if (positions.isEmpty()) {
            throw new PositionNotFoundException("Position with department id " + departmentId + " not found");
        }
        return positions;
    }

    @Override
    public List<Position> findByEmployee(Employee employeeId) throws PositionNotFoundException {
        List<Position> positions = jobPositionRepo.findByEmployee(employeeId);
        if (positions.isEmpty()) {
            throw new PositionNotFoundException("Position with employee id " + employeeId + " not found");
        }
        return positions;

    }

    @Override
    public List<Position> findAll() {
        return jobPositionRepo.findAll();
    }

   // @Override
//    public List<Position> findByEmployeeCount() {
//        return jobPositionRepo.findByEmployeeCount();
//    }

//    @Override
//    public List<Position> findByEmployeeCount(Long departmentId) {
//        return jobPositionRepo.findByEmployeeCount(departmentId);
//
//    }

    @Override
    public Position getPositionById(Long positionId) {
        return jobPositionRepo.findById(positionId)
                .orElseThrow(() -> new PositionNotFoundException("Position with ID "+positionId+" not found."));
    }

    @Override
    public void deletePosition(Long positionId) {
        if(!existsById(positionId)){
            throw new PositionNotFoundException("Position with ID "+positionId+" not found.");
        }
        try {
            jobPositionRepo.deleteById(positionId);
        } catch (Exception e) {
            throw new PositionDeletionFailedException("Failed to delete position with ID "+positionId+".");
        }
    }

    @Override
    public boolean existsById(Long id) {
        return jobPositionRepo.existsById(id);
    }
//////////////////////////////////////////////////////////////////////////////

}