package com.example.greenpotback.Plant;

import com.example.greenpotback.Plant.Calendar.Calendar;
import com.example.greenpotback.Plant.Image.Image;
import com.example.greenpotback.Plant.MainCategory.MainCategory;
import com.example.greenpotback.Plant.SubCategory.SubCategory;
import com.example.greenpotback.User.User;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @Column(length = 4095)
    private String description;

    @Column(length = 4095)
    private String requirements;

    @Column(length = 4095)
    private String planting;

    @Column(length = 4095)
    private String growing;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private MainCategory category;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(
            mappedBy = "plant",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Image> images = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    @JoinTable(
            name = "plant_sub_category",
            joinColumns = @JoinColumn(name = "plant_id"),
            inverseJoinColumns = @JoinColumn(name = "sub_category_id"))
    private Set<SubCategory> subCategories = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "plant",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private List<Calendar> calendar = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(mappedBy = "observedPlant",fetch = FetchType.LAZY)
    private Set<User> observers = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "author")
    private User author;
}
