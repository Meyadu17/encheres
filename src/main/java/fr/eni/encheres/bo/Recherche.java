package fr.eni.encheres.bo;

import lombok.*;
import org.springframework.stereotype.Component;


@Builder
@AllArgsConstructor
@Data
@Component
@Getter
@Setter
public class Recherche{

    private String keyword;

    public Recherche() {
    }

}
