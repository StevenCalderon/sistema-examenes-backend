package com.sistema.examenes.entidades;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // Esta notacion sirve para que sea una entidad y se mapee con la base de datos
@Table(name = "usuarios") // Es para indicar el nombre de la tabla
public class Usuario {
    @Id // para indicar q este valor va ser el unico
    @GeneratedValue(strategy = GenerationType.IDENTITY) // para indicar que este valor va ser autoincrementable
    private Long id;

    private String username;
    private String password;
    private String nombre;
    private String email;
    private String telefono;
    private Boolean enable = true;
    private String perfil;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "usuario")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();

    // CascadeType.ALL --> Quiere decir que cualquier cambio que se realice en la
    // propiedad usuarioRoles de la clase USUARIO Afectara tambien a sus relaciones
    // en este caso
    // afectara tambien a la clase UsuarioRol es decir si se eliminar, actuliza y
    // crea usuarioRoles tambien se creara/acturlizar/eliminar un objeto de la clase
    // UsuarioRol

    // fetch --> controla como seran cargadas las propiedades de esta variable, hay
    // dos tipos EAGER Y LAZY, si es EAGER cuando se llame a un objeto Usuario
    // entonces se cargaran con todos los datos inclusive los datos de la variable
    // usuarioRoles,

    // Si es lazy secargara solamente cuando se llame al objeto con la propiedad es
    // decir "Usuario objUsuario= new Usuario(); objUsuario.usuarioRoles." ahi
    // recien se cargaran todos los datos de esta variable.

    // Se usa EAGER cuando siempre se usara esta variable y se usa LAZY cuando no
    // siempre usemos los datos de esta variable haciendo que la paplicacion sea
    // menos pesada.

    /**
     * @return Long return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return Boolean return the enable
     */
    public Boolean isEnable() {
        return enable;
    }

    /**
     * @param enable the enable to set
     */
    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    /**
     * @return String return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * @return Set<UsuarioRol> return the usuarioRoles
     */
    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    /**
     * @param usuarioRoles the usuarioRoles to set
     */
    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

}
