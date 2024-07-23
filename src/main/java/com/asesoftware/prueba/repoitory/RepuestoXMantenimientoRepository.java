package com.asesoftware.prueba.repoitory;

import com.asesoftware.prueba.model.Mantenimiento;
import com.asesoftware.prueba.model.RepuestoXMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;

        import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepuestoXMantenimientoRepository extends JpaRepository<RepuestoXMantenimiento, Integer> {
    List<RepuestoXMantenimiento> findByMantenimiento(Mantenimiento mantenimiento);

}
