package com.api.digitalbank.resource;

import com.api.digitalbank.models.Pessoa;

import com.api.digitalbank.repository.PessoaRepository;
import com.api.digitalbank.service.PessoaService;
import com.api.digitalbank.exception.MenorIdadeException;
import com.api.digitalbank.exception.UnicidadeCpfException;
import com.api.digitalbank.exception.UnicidadeEmailException;
import com.api.digitalbank.exception.UnicidadeValidaEmailException;
import com.api.digitalbank.exception.ValidaCpfException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaRepository repository;

   

    @PostMapping
    public ResponseEntity<Pessoa> salvarNova(@RequestBody Pessoa pessoa, HttpServletResponse response) throws UnicidadeCpfException, UnicidadeEmailException,MenorIdadeException,UnicidadeValidaEmailException,ValidaCpfException {
        final Pessoa pessoaSalva = pessoaService.salvar(pessoa);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .buildAndExpand().toUri();
        response.setHeader("Location", uri.toASCIIString());

        return new ResponseEntity<>(pessoaSalva, HttpStatus.CREATED);
    }

    

    @ExceptionHandler({UnicidadeCpfException.class})
    public ResponseEntity<Erro> handleUnicidadeCpfException(UnicidadeCpfException e) {
        return new ResponseEntity<>(new Erro(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({UnicidadeEmailException.class})
    public ResponseEntity<Erro> handleUnicidadeEmailException(UnicidadeEmailException e) {
        return new ResponseEntity<>(new Erro(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({UnicidadeValidaEmailException.class})
    public ResponseEntity<Erro> handleUnicidadeValidaEmailException(UnicidadeValidaEmailException e) {
        return new ResponseEntity<>(new Erro(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({ValidaCpfException.class})
    public ResponseEntity<Erro> handleValidaCpfException(ValidaCpfException e) {
        return new ResponseEntity<>(new Erro(e.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({MenorIdadeException.class})
    public ResponseEntity<Erro> handleMenorIdadeException(MenorIdadeException e) {
        return new ResponseEntity<>(new Erro(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    

    class Erro {
        private final String erro;

        public Erro(String erro) {
            this.erro = erro;
        }

        public String getErro() {
            return erro;
        }
    }

}
