package med.voll.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosAtualizacaoMedico;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;



/*Esses controladores são responsáveis por receber as solicitações dos usuários, 
processá-las e tomar as medidas apropriadas para manipular os dados e fornecer uma resposta adequada.
*/
@RestController // Anotação que fornece todas as resposta de um HTTP no formato Json.
@RequestMapping("medicos") // Anotação em que mapea o endpoint de uma Url.
public class MedicoController {

    @Autowired //Essa anotção é uma Injeção Dependência, que instacia um novo objeto toda vez que é chamada.
    private MedicoRepository repository;

    @PostMapping //Anotação que faz uma requisição do tipo POST na API.
    @Transactional // Anatoção que faz toda transação com banco de dados, nesse caso irá postar um cadastro no banco de dados.
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){ // A anotação @RequestBody irá ler o corpo da requisão no formato Json, a anotação @Valid esta informando que na variavel tem validações necessarias para o POST.
        repository.save(new Medico(dados)); // Aqui esta salvando a requisição no banco de dados. 

    }
   
    @GetMapping //Anotação que faz uma requisição do tipo GET na API.

    /* A classe Page é uma estrutyura que representa uma página de uma consulta em um baco de dados.
    A anotção @PageableDefault ela altera o padrão da classe Pageable ex: size, sort
    O retorno desse método ele mapea DadosListarMedico e seu Construtor para mostrar na pagina e volta o medico ativo.**/
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){ 
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping//Anotação que faz uma requisição do tipo PUT na API.
    @Transactional // Anatoção que faz toda transação com banco de dados, nesse caso irá postar um cadastro no banco de dados.
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id()); //criou uma variavel medico e se referenciou para busca o Id.
        medico.atualizarinformacoes(dados);// Pegou a variou medico que tem consigo o Id e atualizou as informções.

    }
     
    @DeleteMapping("/{id}")//Anotação que faz uma requisição do tipo Delete na API,  passando como parâmetro o Id.
    @Transactional// Anatoção que faz toda transação com banco de dados, nesse caso irá postar um cadastro no banco de dados.
    public void excluir(@PathVariable Long id) { //A anotação @PathVariable percorre o camionho da variavel Id.
     var medico = repository.getReferenceById(id);//criou uma variavel medico e se referenciou para busca o Id.
        medico.excluir();// Pegou a variou medico que tem consigo o Id e excluiu parcialmente.
    }

}
