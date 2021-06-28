package dio.expertostech.cliente.crud.controller;

import dio.expertostech.cliente.crud.model.Cliente;
import dio.expertostech.cliente.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Cliente>> listarTodos(){
        Optional<List<Cliente>> clientes = Optional.of(clienteRepository.findAll());
        return ResponseEntity.of(clientes);
    }

    @PostMapping("/salvar")
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente){
        return ResponseEntity.ok(clienteRepository.save(cliente));
    }

}
