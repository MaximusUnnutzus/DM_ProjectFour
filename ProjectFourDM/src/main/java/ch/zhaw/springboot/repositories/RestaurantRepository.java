package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.restaurants;

public interface RestaurantRepository extends JpaRepository<restaurants, Long>{

}
