package com.asesoftware.prueba.controller;

import com.asesoftware.prueba.CarCenterApplication;
import com.asesoftware.prueba.model.Cliente;
import com.asesoftware.prueba.model.ClienteId;
import com.asesoftware.prueba.services.ClienteService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CarCenterApplication.class)
//@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {
    private MockMvc mockMvc;

    @Mock
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    private Cliente cliente;

    @Autowired
    private WebApplicationContext wac;

    @Before
    public void init(){
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        //gson = new Gson();
    }

    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.openMocks(this);
        cliente = new Cliente();
        cliente.setTipoDocumento("CC");
        cliente.setDocumento(123456);
        cliente.setPrimerNombre("Juan");
        cliente.setSegundoNombre("Carlos");
        cliente.setPrimerApellido("Perez");
        cliente.setSegundoApellido("Gomez");
        cliente.setCelular("3001234567");
        cliente.setDireccion("Calle 123");
        cliente.setEmail("juan.perez@example.com");
        cliente.setEstado('A');
        cliente.setPresupuesto(10000.0);
    }

    @Test
    public void testGetAllClientes() {
        List<Cliente> clientes = Arrays.asList(cliente);
        when(clienteService.findAll()).thenReturn(clientes);

        List<Cliente> result = clienteController.getAllClientes();

        assertEquals(1, result.size());
        verify(clienteService, times(1)).findAll();
    }

    @Test
    public void testGetClienteById() {
        ClienteId clienteId = new ClienteId("CC", 123456);
        when(clienteService.findById(clienteId)).thenReturn(Optional.of(cliente));

        ResponseEntity<Cliente> response = clienteController.getClienteById("CC", 123456);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
        verify(clienteService, times(1)).findById(clienteId);
    }

    @Test
    public void testCreateCliente() {
        when(clienteService.save(any(Cliente.class))).thenReturn(cliente);

        Cliente result = clienteController.createCliente(cliente);

        assertEquals(cliente, result);
        verify(clienteService, times(1)).save(cliente);
    }

    @Test
    public void testUpdateCliente() {
        ClienteId clienteId = new ClienteId("CC", 123456789);
        when(clienteService.findById(clienteId)).thenReturn(Optional.of(cliente));
        when(clienteService.save(any(Cliente.class))).thenReturn(cliente);

        Cliente updatedCliente = new Cliente();
        updatedCliente.setPrimerNombre("Pedro");
        updatedCliente.setSegundoNombre("Carlos");
        updatedCliente.setPrimerApellido("Perez");
        updatedCliente.setSegundoApellido("Gomez");
        updatedCliente.setCelular("3001234567");
        updatedCliente.setDireccion("Calle 123");
        updatedCliente.setEmail("pedro.carlos@example.com");
        updatedCliente.setEstado('A');
        updatedCliente.setPresupuesto(20000.0);

        ResponseEntity<Cliente> response = clienteController.updateCliente("CC", 123456789, updatedCliente);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(clienteService, times(1)).findById(clienteId);
        verify(clienteService, times(1)).save(cliente);
    }


    @Test
    public void testDeleteCliente() {
        ClienteId clienteId = new ClienteId("CC", 123456789);
        when(clienteService.findById(clienteId)).thenReturn(Optional.of(cliente));

        ResponseEntity<Void> response = clienteController.deleteCliente("CC", 123456789);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(clienteService, times(1)).findById(clienteId);
        verify(clienteService, times(1)).deleteById(clienteId);
    }
}
