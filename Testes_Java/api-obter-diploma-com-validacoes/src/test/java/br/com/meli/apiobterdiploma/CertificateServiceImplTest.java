package br.com.meli.apiobterdiploma;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.meli.apiobterdiploma.entity.Aluno;
import br.com.meli.apiobterdiploma.entity.Diploma;
import br.com.meli.apiobterdiploma.entity.Disciplina;
import br.com.meli.apiobterdiploma.exception.LowAverageException;
import br.com.meli.apiobterdiploma.repository.DiplomaRepository;
import br.com.meli.apiobterdiploma.service.DiplomaService;

@SpringBootTest
public class CertificateServiceImplTest {
	List<Disciplina> disciplinas;
	Aluno aluno;
	
	@Autowired
	private DiplomaService diplomaService;
	
	@BeforeEach
	public void init() {
		disciplinas = null;
	}
	
	@Test
	public void deve_RetornarMediaSeMaiorQueCinco() {
		disciplinas = Arrays.asList(new Disciplina("Portugues", 10));
		aluno = new Aluno("Elvis", disciplinas);
		double mediaEsperada = 10;
		double mediaRetornada;
		
		mediaRetornada = diplomaService.calculateAverage(aluno);
		
		assertEquals(mediaEsperada, mediaRetornada);
	}
	
	@Test
	public void deve_LevantarExcecaoSeMediaMenorQueCinco() {
		disciplinas = Arrays.asList(new Disciplina("Portugues", 3));
		aluno = new Aluno("Elvis", disciplinas);
		
		assertThrows(LowAverageException.class, () -> diplomaService.calculateAverage(aluno));
	}
	
	@Test
	public void deve_EscreverMensagemDeParabens() {
		String mensagemEsperada = ". Parabéns!";
		
		String messagemRetornada = diplomaService.writeDiploma(true);
		
		assertEquals(mensagemEsperada, messagemRetornada);
	}
	
	@Test
	public void deve_NaoEscreverMensagemDeParabens() {
		String mensagemEsperada = ".";
		
		String messagemRetornada = diplomaService.writeDiploma(false);
		
		assertEquals(mensagemEsperada, messagemRetornada);
	}
	
	@Test
	public void deve_RetornarTrueWithHonnor() {
		boolean respostaEsperada = true;
		
		boolean respostaRetornada = diplomaService.withHonors(10);
		
		assertEquals(respostaEsperada, respostaRetornada);
	}
	
	@Test
	public void deve_RetornarFalseWithHonnor() {
		boolean respostaEsperada = true;
		
		boolean respostaRetornada = diplomaService.withHonors(5);
		
		assertNotEquals(respostaEsperada, respostaRetornada);
	}
	
}
