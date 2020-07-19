package com.money.api.resource;

import com.money.api.event.RecursoCriadoEvent;
import com.money.api.model.Lancamento;
import com.money.api.repository.LancamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoResource {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    @GetMapping
    public List<Lancamento> listar() {
        return this.lancamentoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Lancamento> criar (@Valid @RequestBody Lancamento lancamento, HttpServletResponse response) {
        final Lancamento lancamentoSalvo = this.lancamentoRepository.save(lancamento);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, lancamentoSalvo.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(lancamentoSalvo);
    }
}
