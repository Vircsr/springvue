package com.acgames.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="video")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String cover;
    private String title;
    private String introduction;

//    private String author;
    private int authid;
//    @ManyToOne
//    @JoinColumn(name = "authid")
//    private User user;

    @ManyToOne
    @JoinColumn(name="varid")
    private Variety variety;

    private String content;
    private int hits;
    private int likes;
    @Column(name = "create_time")
    private Timestamp createTime;
    @Column(name = "update_time")
    private Timestamp updateTime;
}
