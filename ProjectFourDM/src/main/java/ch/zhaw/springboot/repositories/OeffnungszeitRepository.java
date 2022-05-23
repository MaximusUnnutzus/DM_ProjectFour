package ch.zhaw.springboot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zhaw.springboot.entities.Oeffnungszeit;

public interface OeffnungszeitRepository extends JpaRepository<Oeffnungszeit, Long>{

}
