package com.marianaquintino.PrjEmpresa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marianaquintino.PrjEmpresa.entities.Funcionario;
import com.marianaquintino.PrjEmpresa.repositories.FuncionarioRepository;

@Service
public class FuncionarioService {

	@Autowired
	
	private FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> getAllFuncionario(){
		return funcionarioRepository.findAll();
	}
	
	public  Funcionario getFuncionarioById(Long Funcodigo) {
		return funcionarioRepository.findById(Funcodigo).orElse(null);
	}
	
	public Funcionario saveFuncionario(Funcionario funcionario) {
		return funcionarioRepository.save(funcionario);
	}
	
	public List<Funcionario> getFuncionariosByFunnomeAproximado(String funnome) {
        return funcionarioRepository.findByNomeContaining(funnome);
    }
	
	public boolean deleteFuncionario(Long id) {
		Optional<Funcionario> funcionarioExistente = funcionarioRepository.findById(id);
		if (funcionarioExistente.isPresent()) {
			funcionarioRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
	
	public Funcionario updateFuncionario(Long Funcodigo, Funcionario novoFuncionario) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(Funcodigo);
		if (funcionarioOptional.isPresent()) {
			Funcionario funcionarioExistente = funcionarioOptional.get();
			funcionarioExistente.setFunnome(novoFuncionario.getFunnome());
			funcionarioExistente.setFunnascimento(novoFuncionario.getFunnascimento());
			funcionarioExistente.setFunsalario(novoFuncionario.getFunsalario());
			
			// Atualize o departamento
						if (novoFuncionario.getDepartamento() != null) {
							funcionarioExistente.setDepartamento(novoFuncionario.getDepartamento());
						}		
						return funcionarioRepository.save(funcionarioExistente);
					} else {
						return null; // Ou lançar uma exceção indicando que o funcionário não foi encontrado
					}
				}		
}
