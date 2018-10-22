package br.com.una.customer.customer.dto;

import br.com.una.customer.customer.enumeration.State;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class CityDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo obrigatório")
    @Length(min = 3, max = 80, message = "O tamanho deve ser entre 3 e 80 caracteres")
    private String name;

    private State state;

    public CityDTO(Integer id, String name, State state) {
        this.id = id;
        this.name = name;
        this.state = state;
    }

    public CityDTO(String name, State state) {
        this.name = name;
        this.state = state;
    }

    public CityDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
