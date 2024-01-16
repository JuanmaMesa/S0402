package cat.itacademy.barcelonactiva.SanchezMesa.JuanManuel.s04.t02.n01.S04T02N01.model.domain;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Integer numberKg;// Integer -> permitimos que sea nul en h2


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberKg() {
        return numberKg;
    }

    public void setNumberKg(int numberKg) {
        this.numberKg = numberKg;
    }
}
