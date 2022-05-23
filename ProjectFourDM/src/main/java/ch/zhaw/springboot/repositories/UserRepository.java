package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
