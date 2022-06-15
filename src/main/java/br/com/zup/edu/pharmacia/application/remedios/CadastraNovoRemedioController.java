package br.com.zup.edu.pharmacia.application.remedios;

import br.com.zup.edu.pharmacia.domain.remedios.CadastraNovoRemedioService;
import br.com.zup.edu.pharmacia.domain.remedios.Remedio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/remedios")
public class CadastraNovoRemedioController {

    private final CadastraNovoRemedioService service;

    public CadastraNovoRemedioController(CadastraNovoRemedioService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid CadastraNovoRemedioRequest request,
                                       UriComponentsBuilder uriComponentsBuilder) {
        Remedio remedio = service.cadastrar(request);

        URI location = uriComponentsBuilder.path("/remedios/{id}")
                .buildAndExpand(remedio.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
