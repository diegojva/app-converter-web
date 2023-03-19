package alura.one.challenger.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ApiResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idApiResponse;
    private boolean success;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Query query;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Info info;
    private String date;
    private double result;


}
