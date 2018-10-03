package com.codecool.netflixandchill.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Season extends BaseModel {

    @OneToMany(mappedBy = "season")
    @Column(nullable = false)
    private List<Episode> episodes = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    private Date year;

    @Column(nullable = false)
    private int serialNumber;

    @ManyToOne
    private Series series;

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }
}
