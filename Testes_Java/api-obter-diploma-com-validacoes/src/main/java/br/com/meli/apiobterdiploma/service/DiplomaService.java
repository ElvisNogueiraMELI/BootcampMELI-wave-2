package br.com.meli.apiobterdiploma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meli.apiobterdiploma.entity.Aluno;
import br.com.meli.apiobterdiploma.entity.Diploma;
import br.com.meli.apiobterdiploma.entity.Disciplina;
import br.com.meli.apiobterdiploma.exception.LowAverageException;
import br.com.meli.apiobterdiploma.repository.DiplomaRepository;

@Service
public class DiplomaService {

	private AlunoService alunoService;
	private DiplomaRepository diplomaRepository;

	@Autowired
	public DiplomaService(AlunoService alunoService, DiplomaRepository diplomaRepository) {
		this.alunoService = alunoService;
		this.diplomaRepository = diplomaRepository;
	}

	public Diploma createDiploma(long id) {
		Aluno aluno = alunoService.getById(id);
		double media = calculateAverage(aluno);
		String mensagem = "Sua média é "+media;
		
		boolean honnor = withHonors(media);
		mensagem+=writeDiploma(honnor);

		return diplomaRepository.gerarDiploma(aluno.getNome(),media,mensagem);
	}
	
	public double calculateAverage(Aluno aluno) {
		double media = aluno.getDisciplinas()
				.stream().mapToInt(Disciplina::getNota)
				.average().getAsDouble();
		
		if(media<5)
			throw new LowAverageException("Não foi possível criar o certificado. A média do aluno está abaixo dos "
					+ "requisitos mínimos!");
		
		return media;
	}
	
	public boolean withHonors(double average) {
		return (average>9)?true:false;
	}
	
	public String writeDiploma(boolean honnor) {
		return honnor?". Parabéns!":".";
	}

	
}
