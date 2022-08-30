package com.jacopx.comments.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 50)
    private String firstName;
    @Column(length = 50)
    private String lastName;
    @Column(length = 50)
    private String email;
    @Column(length = 15)
    private String phone;

    @OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL)
    private List<ProductComment> commentId;

    @OneToMany(mappedBy ="user" ,cascade = CascadeType.ALL)
    private List<Product> productId;

}
