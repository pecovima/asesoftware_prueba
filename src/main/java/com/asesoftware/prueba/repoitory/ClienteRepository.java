package com.asesoftware.prueba.repoitory;

import com.asesoftware.prueba.model.Cliente;
import com.asesoftware.prueba.model.ClienteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, ClienteId> {
    Optional<Cliente> findByDocumento(Integer documento);

}
