package br.com.zup.edu.pharmacia.adapters.persistence.remedios;

import br.com.zup.edu.pharmacia.domain.remedios.Remedio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemedioRepository extends JpaRepository<Remedio, Long> {
}
