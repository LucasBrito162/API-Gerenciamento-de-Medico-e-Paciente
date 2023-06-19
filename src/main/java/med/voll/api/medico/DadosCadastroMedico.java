package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroMedico(

        @NotBlank String nome, //Anotação @NotBlank indica que o campo não pode ser vazio e não pode ser nulo, referenciado somente em String.

        @NotBlank @Email String email, // Anotação @Email indica que vai receber o formato de um email.

        @NotBlank String telefone,

        @NotBlank @Pattern(regexp = "\\d{4,6}") String crm, //A anotação @Pattern é para passar uma expressão regular.

        @NotNull Especialidade especialidade,

        @NotNull @Valid DadosEndereco endereco) {

}
