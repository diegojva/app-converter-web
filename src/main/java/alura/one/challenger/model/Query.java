package alura.one.challenger.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;

@Data
@Entity
@Table(name = "query")
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idQuery;
    @Column(name = "from_currency")
    private String from;
    @Column(name = "to_currency")
    private String to;
    private String amount;
    private String symbolFrom;
    private String symbolTo;
}
