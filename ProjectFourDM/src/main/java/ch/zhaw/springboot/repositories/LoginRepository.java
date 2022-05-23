package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Login;

public interface LoginRepository extends JpaRepository<Login, Long>{

}
