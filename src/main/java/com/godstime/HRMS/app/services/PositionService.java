package com.godstime.HRMS.app.services;

import com.godstime.HRMS.app.entities.Employee;
import com.godstime.HRMS.app.entities.Position;
import com.godstime.HRMS.app.exceptions.PositionNotFoundException;

import java.util.List;

public interface PositionService {

    Position findById(Long id) throws PositionNotFoundException;
    Position findByFirstName(String firstName) throws PositionNotFoundException;
    List<Position> findByDepartment(Long departmentId) throws PositionNotFoundException;
    List<Position> findByEmployee(Employee employeeId) throws PositionNotFoundException;
    List<Position> findAll();
  //  List<Position> findByEmployeeCount();
   // List<Position> findByEmployeeCount(Long departmentId);


    boolean existsById(Long id);

    Position updatePosition(Long positionId, Position position);

    Position createPosition(Position position);

    void deletePosition(Long positionId);

    Position getPositionById(Long positionId);
}

