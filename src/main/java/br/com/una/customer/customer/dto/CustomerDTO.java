package br.com.una.customer.customer.dto;

import br.com.una.customer.customer.enumeration.Genre;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.Objects;

public class CustomerDTO {

    private Integer id;

    @NotNull(message = "Campo obrigatório")
    private String name;

    private String phone;

    @NotNull(message = "Campo obrigatório")
    private Integer cityId;

    @NotNull(message = "Campo obrigatório")
    private String publicPlace;

    @NotNull(message = "Campo obrigatório")
    private Integer number;

    @NotNull(message = "Campo obrigatório")
    private String neighborhood;

    @NotNull(message = "Campo obrigatório")
    private String cep;

    @NotNull(message = "Campo obrigatório")
    @CPF
    private String cpf;

    @NotNull(message = "Campo obrigatório")
    @Email
    private String email;

    @NotNull(message = "Campo obrigatório")
    private Genre genre;

    @NotNull(message = "Campo obrigatório")
    private Date birth;

    public CustomerDTO(final Integer id,
                       final String name,
                       final String phone,
                       final Integer cityId,
                       final String publicPlace,
                       final Integer number,
                       final String neighborhood,
                       final String cep,
                       final String cpf,
                       final String email,
                       final Genre genre,
                       final Date birth) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.cityId = cityId;
        this.publicPlace = publicPlace;
        this.number = number;
        this.neighborhood = neighborhood;
        this.cep = cep;
        this.cpf = cpf;
        this.email = email;
        this.genre = genre;
        this.birth = birth;
    }

    public CustomerDTO(final String name,
                       final String phone,
                       final Integer cityId,
                       final String publicPlace,
                       final Integer number,
                       final String neighborhood,
                       final String cep,
                       final String cpf,
                       final String email,
                       final Genre genre,
                       final Date birth) {
        this.name = name;
        this.phone = phone;
        this.cityId = cityId;
        this.publicPlace = publicPlace;
        this.number = number;
        this.neighborhood = neighborhood;
        this.cep = cep;
        this.cpf = cpf;
        this.email = email;
        this.genre = genre;
        this.birth = birth;
    }

    public CustomerDTO() {
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public void setPublicPlace(String publicPlace) {
        this.publicPlace = publicPlace;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO that = (CustomerDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(cityId, that.cityId) &&
                Objects.equals(publicPlace, that.publicPlace) &&
                Objects.equals(number, that.number) &&
                Objects.equals(neighborhood, that.neighborhood) &&
                Objects.equals(cep, that.cep) &&
                Objects.equals(cpf, that.cpf) &&
                Objects.equals(email, that.email) &&
                genre == that.genre &&
                Objects.equals(birth, that.birth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phone, cityId, publicPlace, number, neighborhood, cep, cpf, email, genre, birth);
    }
}
