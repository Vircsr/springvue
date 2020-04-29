package com.acgames.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@Table(name = "recommends")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Recommends {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "video_id")
    private Video video;
}
