package br.com.fiap.alertempo.repository;

import br.com.fiap.alertempo.model.Alerta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertaRepository extends JpaRepository<Alerta, Long> {
}
