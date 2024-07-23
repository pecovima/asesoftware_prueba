package com.asesoftware.prueba.repoitory;

import com.asesoftware.prueba.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Integer> {


    //List<Mantenimiento> findByEstadoAndVehiculo_Placa(String estado, String placa);

    List<Mantenimiento> findByEstadoAndVehiculo_PlacaAndMecanico_Documento(String estado, String placa, Integer documento);



}

