package Service;

import Entity.Drone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    public Drone getDroneById(Long droneId) {
        return droneRepository.findById(droneId).orElse(null);
    }

    public Drone createDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public Drone updateDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public void deleteDroneById(Long droneId) {
        droneRepository.deleteById(droneId);
    }
}
