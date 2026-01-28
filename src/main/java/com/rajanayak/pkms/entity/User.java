package com.rajanayak.pkms.entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    private ObjectId id;

    @NotBlank(message = "Username must not be blank")
    @Size(min = 3, max = 50)
    @Indexed(unique = true)
    private String username;

    @NotBlank(message = "Email must not be blank")
    @Email(message = "Invalid email format")
    @Indexed(unique = true)
    private String email;

    @NotBlank(message = "Password must not be blank")
    @Size(min = 8)
    private String password;

    @NotNull
    private String role;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
