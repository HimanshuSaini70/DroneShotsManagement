package Controller;

import Entity.Drone;
import Service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/drones")
public class DroneController {

    @Autowired
    private DroneService droneService;

    @GetMapping
    public List<Drone> getAllDrones() {
        return droneService.getAllDrones();
    }

    @GetMapping("/{id}")
    public Drone getDroneById(@PathVariable("id") Long id) {
        return droneService.getDroneById(id);
    }

    @PostMapping
    public ResponseEntity<Drone> createDrone(@RequestBody Drone drone) {
        droneService.createDrone(drone);
        return new ResponseEntity<>(drone, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drone> updateDrone(@PathVariable("id") Long id, @RequestBody Drone drone) {
        droneService.updateDrone( drone);
        return new ResponseEntity<>(drone, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrone(@PathVariable("id") Long id) {
        droneService.deleteDroneById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

