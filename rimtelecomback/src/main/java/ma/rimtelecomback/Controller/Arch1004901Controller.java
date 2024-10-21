package ma.rimtelecomback.Controller;

import ma.rimtelecomback.DTO.GpsCoordinatesDTO;
import ma.rimtelecomback.Service.Arch1004901Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/gps")
public class Arch1004901Controller {
    private Arch1004901Service arch1004901Service;

    public Arch1004901Controller(Arch1004901Service arch1004901Service) {
        this.arch1004901Service = arch1004901Service;
    }

    @GetMapping("/coordinates")
    public List<GpsCoordinatesDTO> getCoordinates() {
        return arch1004901Service.getAllGpsCoordinates();
    }
}
