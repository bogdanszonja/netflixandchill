package com.codecool.netflixandchill.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Episode extends BaseModel {

    @Column(nullable = false)
    private Date releaseDate;

    @Column(nullable = false)
    private int runtime;

    @Column(nullable = false)
    private int serialNumber;

    @ManyToOne
    private Season season;

    @ManyToMany(mappedBy = "watchedEpisodes", fetch = FetchType.EAGER)
    private List<User> users = new ArrayList<>();

    @Builder
    public Episode(String title, String description, Date releaseDate, int runtime, int serialNumber) {
        super(title, description);
        this.releaseDate = releaseDate;
        this.runtime = runtime;
        this.serialNumber = serialNumber;
    }

    public void addUser(User user) {
        users.add(user);
    }
}
