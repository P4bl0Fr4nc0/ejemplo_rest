package com.example.empleados.service;


import com.example.empleados.dto.EmpleadoDTO;
import com.example.empleados.entity.Empleado;
import com.example.empleados.exception.EmpleadoNoEncontradoException;
import com.example.empleados.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.EmptyStackException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpleadoService {



    private final EmpleadoRepository empleadoRepository;

    @Autowired
    public EmpleadoService (EmpleadoRepository empleadoRepository){

        this.empleadoRepository = empleadoRepository;
    }

    public List<EmpleadoDTO> getAllEmpleados(){
        List<Empleado> empleados = empleadoRepository.findAll();
        return empleados.stream().map(empleado -> new EmpleadoDTO(empleado.getId(),empleado.getNombre(),
                empleado.getApaterno(),empleado.getAmaterno())).collect(Collectors.toList());

    }


    public EmpleadoDTO getEmpleado(Long id){
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(()->new EmpleadoNoEncontradoException("Empledo no encontrado con id " + id));

        return new EmpleadoDTO(empleado.getId(), empleado.getNombre(), empleado.getApaterno(),empleado.getAmaterno());
    }

    public EmpleadoDTO creteEmpleado(EmpleadoDTO empleadoDTO){

        Empleado empleado = new Empleado();

        empleado.setId(empleadoDTO.id());
        empleado.setNombre(empleadoDTO.nombre());
        empleado.setApaterno(empleadoDTO.apaterno());
        empleado.setAmaterno(empleadoDTO.amaterno());
        Empleado nuevoEmpleado = empleadoRepository.save(empleado);
        return  new EmpleadoDTO(nuevoEmpleado.getId(),nuevoEmpleado.getNombre(),nuevoEmpleado.getApaterno(),nuevoEmpleado.getAmaterno());

    }

    public EmpleadoDTO updateEmpleado(Long id, EmpleadoDTO empleadoDTO){
        Empleado empleado = empleadoRepository.findById(id). orElseThrow(()-> new
                EmpleadoNoEncontradoException("Empleado con el id " + id + " no existe"));

        empleado.setNombre(empleadoDTO.nombre());
        empleado.setApaterno(empleadoDTO.apaterno());
        empleado.setAmaterno(empleadoDTO.amaterno());

        Empleado empleadoActualizado = empleadoRepository.save(empleado);
        return  new EmpleadoDTO(
                empleadoActualizado.getId(),
                empleadoActualizado.getNombre(),
                empleadoActualizado.getApaterno(),
                empleadoActualizado.getAmaterno());


    }

    public void deleteEmpleado(Long id){


         empleadoRepository.deleteById(id);

    }




}
