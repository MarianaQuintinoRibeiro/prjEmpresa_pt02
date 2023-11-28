package com.marianaquintino.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marianaquintino.PrjEmpresa.entities.Departamento;
import com.marianaquintino.PrjEmpresa.repositories.DepartamentoRepository;

@Service
public class DepartamentoService {

	private static DepartamentoRepository departamentoRepository;

	@Autowired
	public DepartamentoService(DepartamentoRepository departamentoRepository) {
		this.departamentoRepository = departamentoRepository;
}
	
	public Departamento getDepartamentoById(Long Depcodigo) {
		return departamentoRepository.findById(Depcodigo).orElse(null);
	}
	public List<Departamento> getAllDepartamentoDepartamento(){
		return departamentoRepository.findAll();
	}
	public Departamento saveDepartamento(Departamento departamento) {
		return departamentoRepository.save(departamento);
	}
	public static void deleteDepartamento(Long Depcodigo) {
		departamentoRepository.deleteById(Depcodigo);
	}
	public Departamento updateDepartamento(Long Depcodigo, Departamento novoDepartamento) {
		Optional<Departamento> departamentoOptional = departamentoRepository.findById(Depcodigo);
		if (departamentoOptional.isPresent()) {
			Departamento funcionarioExistente = departamentoOptional.get();
			funcionarioExistente.setDepnome(novoDepartamento.getDepnome());
			return departamentoRepository.save(funcionarioExistente);
		}else {
			return null;
			
		}
	}
}
