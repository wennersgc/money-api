package com.money.api.resource;

import com.money.api.event.RecursoCriadoEvent;
import com.money.api.model.Pessoa;
import com.money.api.repository.PessoaRepository;
import com.money.api.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Pessoa> listar() {
        return this.pessoaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid  @RequestBody Pessoa pessoa, HttpServletResponse response) {
        final Pessoa pessoaSalva = this.pessoaRepository.save(pessoa);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, pessoaSalva.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalva);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Pessoa> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Pessoa> pessoa = this.pessoaRepository.findById(codigo);

        if (pessoa.isPresent()) {
            return ResponseEntity.ok(pessoa.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long codigo) {
        this.pessoaRepository.deleteById(codigo);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long codigo, @Valid @RequestBody Pessoa pessoa) {
        Pessoa pessoaSalva = this.pessoaService.atualizar(codigo, pessoa);
        return ResponseEntity.ok(pessoaSalva);
    }

}
