package com.example.empleados.controller;
import com.example.empleados.dto.EmpleadoDTO;
import com.example.empleados.service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    /* --El codigo comentado fue pasado al paquete de servicios EmpleadoService -- */


    // private final EmpleadoRepository empleadoRepository;


    private final EmpleadoService empleadoService;


    @Autowired
    /*
    public EmpleadoController(EmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }
    */

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }


    @GetMapping    //Obtener todos los empleados
    public ResponseEntity<List<EmpleadoDTO>> getAllEmpleado(){

        List<EmpleadoDTO> empleados = empleadoService.getAllEmpleados();
        return new ResponseEntity<>(empleados, HttpStatus.OK);


        /*
        List<Empleado> empleado = empleadoRepository.findAll();
        List<EmpleadoDTO> empleadoDTOS = empleado.stream()
                .map(empleado1-> new EmpleadoDTO(empleado1.getId(), empleado1.getNombre(),
                        empleado1.getApaterno(), empleado1.getAmaterno())).toList();
        return new ResponseEntity<>(empleadoDTOS, HttpStatus.OK);

         */
    }

    @GetMapping ("/{idEmpleado}") // Obtener empleado por id

    public ResponseEntity<EmpleadoDTO> getEmpleado(@PathVariable("idEmpleado") Long id){
        EmpleadoDTO empleadoDTO = empleadoService.getEmpleado(id);
        return ResponseEntity.ok(empleadoDTO);

    }


    @PostMapping ("/agregar") //Agregar Empleado
    public ResponseEntity<EmpleadoDTO> createEmpleado(@RequestBody EmpleadoDTO empleadosDTO) {

        EmpleadoDTO nuevoEmpleadoDTO = empleadoService.creteEmpleado(empleadosDTO);
        return new ResponseEntity<>(nuevoEmpleadoDTO, HttpStatus.CREATED);

        /*
        Empleado empleado = new Empleado();
        empleado.setId(empleadosDTO.id());
        empleado.setNombre(empleadosDTO.nombre());
        empleado.setApaterno(empleadosDTO.apaterno());
        empleado.setAmaterno(empleadosDTO.amaterno());
        Empleado nuevoEmpleado = empleadoRepository.save(empleado);
        EmpleadoDTO nuevoEmpleadoDTO = new EmpleadoDTO(nuevoEmpleado.getId(), nuevoEmpleado.getNombre(),
        nuevoEmpleado.getApaterno(), nuevoEmpleado.getAmaterno());
        return new ResponseEntity<>(nuevoEmpleadoDTO, HttpStatus.CREATED);
        */

    }

    @PutMapping("/{idEmpleado}") // Actualizar empleado
    public  ResponseEntity<EmpleadoDTO>updateEmpleado(@PathVariable("idEmpleado") Long id, @RequestBody EmpleadoDTO empleadoDTO){
        EmpleadoDTO empleadoActualizadoDTO = empleadoService.updateEmpleado(id,empleadoDTO);
        return new ResponseEntity<>(empleadoActualizadoDTO,HttpStatus.OK);
    }


    @DeleteMapping("/{idEmpleado}") // Eliminar empleado
    public ResponseEntity<String> deleteEmpleado(@PathVariable("idEmpleado") Long id) {

        empleadoService.deleteEmpleado(id);
        return ResponseEntity.ok("usuario eliminado");

    }
    /*public ResponseEntity<String> deleteEmpleado(@PathVariable("idEmpleado") Long idEmpleado) {

        empleadoRepository.deleteById(idEmpleado);
        return ResponseEntity.ok("usuario eliminado");
         }        */


}


