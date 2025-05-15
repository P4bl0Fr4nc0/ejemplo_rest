package com.example.empleados.repository;

import com.example.empleados.entity.Empleado;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;


//Repositorio
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
