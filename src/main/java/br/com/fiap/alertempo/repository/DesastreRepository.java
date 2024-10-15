package br.com.fiap.alertempo.repository;

import br.com.fiap.alertempo.model.Desastre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DesastreRepository extends JpaRepository<Desastre, Long> {
}