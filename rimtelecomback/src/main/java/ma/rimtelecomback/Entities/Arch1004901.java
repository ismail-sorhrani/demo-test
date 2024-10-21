package ma.rimtelecomback.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "arch_1004901")
@Data@NoArgsConstructor@AllArgsConstructor
public class Arch1004901 {

    @EmbeddedId
    private Arch1004901Id id;
    private int speed;
    private int fuel;
    private String temp;
    private int X;
    private int Y;
    private int Z;
    private boolean ignition;
    private int rpm;
    private double fuelRate;
    private double tfu;
    private double odo;
    private int satInView;
    private int signal;
    private int heading;
    private boolean charger;
    private Double latitude;
    private Double longitude;
    private Byte state;
    private Integer tramId;
    private Byte validity;
    private Integer tempEngine;
    private Float accumOdo;
    private Integer do1;
    private Integer do2;
    private Integer do3;
    private Integer do4;
    private Integer di1;
    private Integer di2;
    private Integer di3;
    private Integer di4;
    private Integer an1;
    private Integer an2;
    private Integer an3;
    private Integer an4;

}
