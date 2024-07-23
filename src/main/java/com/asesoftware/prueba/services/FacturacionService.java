package com.asesoftware.prueba.services;

import com.asesoftware.prueba.model.*;
import com.asesoftware.prueba.repoitory.ClienteRepository;
import com.asesoftware.prueba.repoitory.MantenimientoRepository;
import com.asesoftware.prueba.repoitory.RepuestoXMantenimientoRepository;
import com.asesoftware.prueba.repoitory.ServicioXMantenimientoRepository;
import com.asesoftware.prueba.repoitory.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturacionService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private MantenimientoRepository mantenimientoRepository;

    @Autowired
    private ServicioXMantenimientoRepository servicioXMantenimientoRepository;

    @Autowired
    private RepuestoXMantenimientoRepository repuestoXMantenimientoRepository;

    public Factura generarFactura(Integer clienteDocumento, String codPlaca,
                                  Integer documentoMecanico) {
        Cliente cliente = clienteRepository.findByDocumento(clienteDocumento)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        List<Mantenimiento> mantenimientos = null;
        if (codPlaca != null) {
            mantenimientos = mantenimientoRepository.findByEstadoAndVehiculo_PlacaAndMecanico_Documento("terminado", codPlaca, documentoMecanico);

        }

        double totalRepuestos = 0;
        double totalServicios = 0;

        for (Mantenimiento mantenimiento : mantenimientos) {
            List<RepuestoXMantenimiento> repuestosXMantenimiento = repuestoXMantenimientoRepository.findByMantenimiento(mantenimiento);
            List<ServicioXMantenimiento> serviciosXMantenimiento = servicioXMantenimientoRepository.findByMantenimiento(mantenimiento);

            // Calcular el total de repuestos
            for (RepuestoXMantenimiento repuestoXMantenimiento : repuestosXMantenimiento) {
                double precioUnitario = repuestoXMantenimiento.getRepuesto().getPrecioUnitario();
                int unidades = repuestoXMantenimiento.getUnidades(); // Verificar si el campo cantidad está disponible
                totalRepuestos += precioUnitario * unidades;
            }

            // Calcular el total de servicios
            for (ServicioXMantenimiento servicioXMantenimiento : serviciosXMantenimiento) {
                double precioManoDeObra = servicioXMantenimiento.getServicio().getPrecio();
                // Aplicar descuento del 50% si el total de repuestos supera $3,000,000
                if (totalRepuestos > 3000000) {
                    precioManoDeObra *= 0.5; // Descuento del 50%
                }
                totalServicios += precioManoDeObra;
            }
        }

        double totalFactura = totalRepuestos + totalServicios;
        double iva = totalFactura * 0.19;
        double totalConIva = totalFactura + iva;

        // Verificar si el total con IVA supera el presupuesto del cliente
        if (cliente.getPresupuesto() != null && totalConIva > cliente.getPresupuesto()) {
            throw new RuntimeException("El total de la factura supera el presupuesto del cliente");
        }

        Factura factura = new Factura();
        factura.setCliente(cliente);
        factura.setMantenimientos(mantenimientos);
        factura.setTotalRepuestos(totalRepuestos);
        factura.setTotalServicios(totalServicios);
        factura.setTotalFactura(totalFactura);
        factura.setIva(iva);
        factura.setTotalConIva(totalConIva);

        return factura;
    }
}
