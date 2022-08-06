package com.example.greenpotback.Plant.Calendar.Event;

import com.example.greenpotback.Plant.Calendar.Calendar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "event",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Calendar> calendars = new ArrayList<>();
}
