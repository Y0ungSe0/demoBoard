package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity(name="board")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "int default 0")
    private int count;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String nickname;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(nullable = false)
    private Date rdate;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @Column(nullable = true)
    private Date udate;

    public void setRDateTime(){
        this.rdate = new Date(); // 현재 시간으로 설정
    }
    public void setUDateTime(){
        this.udate = new Date();
    }
}
