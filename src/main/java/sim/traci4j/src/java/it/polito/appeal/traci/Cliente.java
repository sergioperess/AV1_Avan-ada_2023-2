package sim.traci4j.src.java.it.polito.appeal.traci;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor

public class Cliente {
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
}
