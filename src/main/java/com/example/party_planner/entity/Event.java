package com.example.party_planner.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "events",indexes = {@Index(name = "index_event_location",columnList = "location"),
        @Index(name = "index_event_interest",columnList = "interest_id"),
@Index(name = "index_event_city",columnList = "is_paid")})
@NoArgsConstructor
@AllArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String location;


    private LocalDateTime dateTime;

    @Column(name = "availableSlots")
    private int availableSlots;

    private boolean isPaid;

    private double price;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE, targetEntity = User.class)
    @JoinColumn(name = "organizer_id")
    private User organizer;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST,targetEntity = Interest.class)
    @JoinColumn(name = "interest_id")
    private Interest interest;


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_event",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    @BatchSize(size = 10)
    private List<User> participants;

    @ElementCollection
    private List<String> games;
}
