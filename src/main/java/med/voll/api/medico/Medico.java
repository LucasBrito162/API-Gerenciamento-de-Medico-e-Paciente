package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos")// Anotação que faz referência a uma tablela no banco de dados.
@Entity(name = "Medicos") // Anotação Entity faz que todas as variaveis interagem com a tabela medicos formando colunas especificas.
@Getter //Essa anotação cria todos os Getters das variaveis.
@NoArgsConstructor // Aqui cria um construtor sem parâmetros que pertir a classe ser instaciada sem receber parâmetros.
@AllArgsConstructor // gerar automaticamente um construtor que aceita todos os campos da classe como parâmetros.
@EqualsAndHashCode(of = "id") // Permite gerar código especifico para variavel mencionada.
public class Medico {

    @Id //representa a chave primaria da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Anotação que faz gerar de forma automatica o valor da chave primaria.
    private long id;
    private String nome;
    private String email;

    private String telefone;

    private String crm;

    @Enumerated(EnumType.STRING) // Anotação que indica que o Enum é uma String e vai persistir no Banco de dados
    private Especialidade especialidade;

    @Embedded //Anotação que informa que os atributos deve ser tratados como integrante da tabela medico.
    private Endereco endereco;

    private boolean ativo;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarinformacoes(@Valid DadosAtualizacaoMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }

        if (dados.endereco() != null) {
            this.endereco.atualizarinformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
