package com.codecool.netflixandchill.model;

import lombok.*;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=true)
@Builder
public class Episode extends BaseModel {

    @Column(nullable = false)
    private Date releaseDate;

    @Column(nullable = false)
    private int runtime;

    @Column(nullable = false)
    private int serialNumber;

    @ManyToOne
    private Season season;

    @Builder.Default
    @ManyToMany(mappedBy = "watchedEpisodes")
    private List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }
}
