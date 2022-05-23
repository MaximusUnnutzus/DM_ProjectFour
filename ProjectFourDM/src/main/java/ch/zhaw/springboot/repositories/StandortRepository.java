package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Standort;

public interface StandortRepository extends JpaRepository<Standort, Long>{

}
