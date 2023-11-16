package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "food")
public class Food {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private double price;

  @OneToOne
  @JoinColumn(name = "user_id") //외래키의 주인만이 외래키를 등록하고 삭제 할 수 있다.
  private User user;
}