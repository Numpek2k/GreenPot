package com.example.greenpotback.Plant.Calendar;

import com.example.greenpotback.Plant.Calendar.Event.Event;
import com.example.greenpotback.Plant.Plant;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Temporal(value = TemporalType.DATE)
    private Date dateStart;

    @Temporal(value = TemporalType.DATE)
    private Date dateEnd;


    @ManyToOne
    @JoinColumn(name = "plant_id")
    private Plant plant;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;
}
