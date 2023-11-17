package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.apache.catalina.valves.AbstractAccessLogValve;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @OneToMany(mappedBy="user", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  private List<Food> foodList = new ArrayList<>();

  public void addFoodList(Food food) {
    this.foodList.add(food);
    food.setUser(this); // 외래 키 설정
  }
}