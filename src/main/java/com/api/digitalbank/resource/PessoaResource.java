package com.api.digitalbank.resource;

import com.api.digitalbank.models.Pessoa;

import com.api.digitalbank.repository.PessoaRepository;
import com.api.digitalbank.service.PessoaService;

import com.api.digitalbank.exception.UnicidadeCpfException;
import com.api.digitalbank.exception.UnicidadeEmailException;

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
    public ResponseEntity<Pessoa> salvarNova(@RequestBody Pessoa pessoa) throws UnicidadeCpfException, UnicidadeEmailException {
        final Pessoa pessoaSalva = pessoaService.salvar(pessoa);

       /* URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{ddd}/{numero}")
                .buildAndExpand(pessoa.getTelefones().get(0).getDdd(), pessoa.getTelefones().get(0).getNumero()).toUri();
        response.setHeader("Location", uri.toASCIIString());*/

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
