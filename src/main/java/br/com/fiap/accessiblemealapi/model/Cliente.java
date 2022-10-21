package br.com.fiap.accessiblemealapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Campo obrigatório")
    private String name;

    @NotBlank(message = "Campo obrigatório")
    private String email;

    @NotBlank(message = "Campo obrigatório")
    private String cpf;

    private boolean isPCD;

    private String typePCD;

    @NotBlank(message = "Campo obrigatório")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    @NotBlank(message = "Campo obrigatório")
    private String address;
    
    public Cliente() {
    }

    //Caso possuir deficiencia
    public Cliente(String name, String email, String cpf, String address, boolean isPCD, String typePCD, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.address = address;
        this.isPCD = isPCD;
        this.typePCD = typePCD;
        this.password = password;
    }

    //Caso nao possuir deficiencia
    public Cliente(String name, String email, String cpf, String address, boolean isPCD, String password) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.address = address;
        this.isPCD = isPCD;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean getIsPCD() {
        return isPCD;
    }

    public void setIsPCD(boolean isPCD) {
        this.isPCD = isPCD;
    }

    public String getTypePCD() {
        return typePCD;
    }

    public void setTypePCD(String typePCD) {
        this.typePCD = typePCD;
    }

    @JsonProperty(access = Access.WRITE_ONLY)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Cliente [cpf=" + cpf + ", email=" + email + ", endereco="
                + address + ", id=" + id + ", nome=" + name + ", password=" + password + ", pcd=" + isPCD + ", tipoPCD=" + typePCD + "]";
    }
    
}
