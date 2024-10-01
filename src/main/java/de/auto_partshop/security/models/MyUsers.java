package de.auto_partshop.security.models;


import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "security")
public class MyUsers {

    @Id
    private ObjectId id;

    @Indexed(unique = true)
    private String name;
    private String password;
    private String roles;
}

