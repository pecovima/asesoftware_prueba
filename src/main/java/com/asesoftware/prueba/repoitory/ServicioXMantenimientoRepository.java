package com.asesoftware.prueba.repoitory;

import com.asesoftware.prueba.model.Mantenimiento;
import com.asesoftware.prueba.model.ServicioXMantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ServicioXMantenimientoRepository extends JpaRepository<ServicioXMantenimiento, Integer> {
    List<ServicioXMantenimiento> findByMantenimiento(Mantenimiento mantenimiento);

}
