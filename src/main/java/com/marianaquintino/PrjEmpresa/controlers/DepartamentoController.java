package com.marianaquintino.PrjEmpresa.controlers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marianaquintino.PrjEmpresa.entities.Departamento;
import com.marianaquintino.PrjEmpresa.services.DepartamentoService;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

private DepartamentoService departamentoService;
	
	@GetMapping("/home")
    public String paginaInicial() {
        return "index"; // Nome do seu arquivo HTML (sem a extensão)
    }

	public void DepartamentoCrontroller(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Departamento> getDepartamento(@PathVariable Long id) {
		Departamento departamento = departamentoService.getDepartamentoById(id);
		if (departamento != null) {
			return ResponseEntity.ok(departamento);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	@PostMapping
	public Departamento createDepartamento(@RequestBody Departamento departamento) {
		return departamentoService.saveDepartamento(departamento);
	}

	@GetMapping
	public ResponseEntity<List<Departamento>> getAllDepartamento(RequestEntity<Void> requestEntity) {
		String method = requestEntity.getMethod().name();
		String contentType = requestEntity.getHeaders().getContentType().toString();
		List<Departamento> departamento = departamentoService.getAllDepartamentoDepartamento();
		return ResponseEntity.status(HttpStatus.OK).header("Method", method).header("Content-Type", contentType)
				.body(departamento);
	}

	@DeleteMapping("/{id}")
	public void deleteDepartamento(@PathVariable Long id) {
		DepartamentoService.deleteDepartamento(id);
	}

	@PutMapping("/{id}")
	public Departamento updateDepartamento(@PathVariable Long id, @RequestBody Departamento departamento) {
		return departamentoService.updateDepartamento(id, departamento);
	}
}
