package com.asesoftware.prueba.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.asesoftware.prueba.CarCenterApplication;
import com.asesoftware.prueba.model.Cliente;
import com.asesoftware.prueba.model.ClienteId;
import com.asesoftware.prueba.repoitory.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarCenterApplication.class)
public class ClienteServiceTest {

    @InjectMocks
    private ClienteService clienteService;

    @Mock
    private ClienteRepository clienteRepository;

    private Cliente cliente;
    private ClienteId clienteId;

    @BeforeEach
    public void setUp() {
        clienteId = new ClienteId("CC", 123456789);
        cliente = new Cliente();
        cliente.setTipoDocumento("CC");
        cliente.setDocumento(123456789);
        cliente.setPrimerNombre("Juan");
        cliente.setSegundoNombre("Carlos");
        cliente.setPrimerApellido("Perez");
        cliente.setSegundoApellido("Gomez");
        cliente.setCelular("3001234567");
        cliente.setDireccion("Calle 123");
        cliente.setEmail("juan.carlos@example.com");
        cliente.setEstado('A');
        cliente.setPresupuesto(15000.0);
    }

    @Test
    public void testFindAll() {
        List<Cliente> clientes = Arrays.asList(cliente);
        when(clienteRepository.findAll()).thenReturn(clientes);

        List<Cliente> result = clienteService.findAll();
        assertEquals(1, result.size());
        assertEquals(clientes, result);
    }

    @Test
    public void testFindById() {
        when(clienteRepository.findById(clienteId)).thenReturn(Optional.of(cliente));

        Optional<Cliente> result = clienteService.findById(clienteId);
        assertTrue(result.isPresent());
        assertEquals(cliente, result.get());
    }

    @Test
    public void testSave() {
        when(clienteRepository.save(cliente)).thenReturn(cliente);

        Cliente result = clienteService.save(cliente);
        assertEquals(cliente, result);
    }

    @Test
    public void testDeleteById() {
        doNothing().when(clienteRepository).deleteById(clienteId);

        clienteService.deleteById(clienteId);
        verify(clienteRepository, times(1)).deleteById(clienteId);
    }
}
