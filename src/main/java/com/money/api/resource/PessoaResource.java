package com.money.api.resource;

import com.money.api.model.Pessoa;
import com.money.api.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> listar() {
        return this.pessoaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Pessoa> criar(@Valid  @RequestBody Pessoa pessoa, HttpServletResponse response) {
        final Pessoa pessoaSalva = this.pessoaRepository.save(pessoa);
        final URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("{/codigo}")
                .buildAndExpand(pessoaSalva.getCodigo()).toUri();

            response.setHeader("Location", uri.toASCIIString());

            return ResponseEntity.created(uri).body(pessoaSalva);
    }

}
