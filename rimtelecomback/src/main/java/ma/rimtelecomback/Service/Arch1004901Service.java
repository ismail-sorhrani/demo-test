package ma.rimtelecomback.Service;

import ma.rimtelecomback.DTO.GpsCoordinatesDTO;
import ma.rimtelecomback.Entities.Arch1004901;
import ma.rimtelecomback.repository.Arch1004901Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Arch1004901Service {

    private Arch1004901Repository arch1004901Repository;

    public Arch1004901Service(Arch1004901Repository arch1004901Repository) {
        this.arch1004901Repository = arch1004901Repository;
    }

    public List<GpsCoordinatesDTO> getAllGpsCoordinates() {
        List<Arch1004901> arch1004901List=arch1004901Repository.findAll();
        List<GpsCoordinatesDTO> gpsCoordinatesDTOSList=new ArrayList<>();
        for (Arch1004901 arch1004901:arch1004901List
             ) {
            GpsCoordinatesDTO gpsCoordinatesDTO=new GpsCoordinatesDTO(arch1004901.getLatitude(),
                    arch1004901.getLongitude());
            gpsCoordinatesDTOSList.add(gpsCoordinatesDTO);

        }
        return gpsCoordinatesDTOSList;
    }
}
