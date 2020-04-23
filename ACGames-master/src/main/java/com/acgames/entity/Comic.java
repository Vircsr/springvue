package com.acgames.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name="comic")
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Comic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "comic_list_id")
    private int comicListId;
    @Column(name = "section_id")
    private int sectionId;
    @Column(name = "section_name")
    private String sectionName;
    @Column(name = "video_url")
    private String videoUrl;
    @Column(name = "create_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp createTime;
    @Column(name = "update_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Timestamp updateTime;

}
