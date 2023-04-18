package com.example.clientes.application;

import com.example.clientes.domain.entities.Cliente;
import com.example.clientes.domain.servicies.ClienteGetService;
import com.example.clientes.domain.servicies.ClienteSaveService;
import com.example.clientes.shared.exception.base.ClientExistsException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
@Slf4j
public class ClienteSave {
  private final ClienteGetService clienteGetService;
  private final ClienteSaveService clienteSaveService;
  public Cliente saveCliente(Cliente cliente){
    Cliente cliente1 =clienteGetService.getCliente(cliente.getId());

    if(!Objects.isNull(cliente1)){
      throw new ClientExistsException("Este cliente ya existe con  esta ID");
    }
    return clienteSaveService.saveCliente(cliente);
  }
}
