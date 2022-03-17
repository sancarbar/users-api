package org.adaschool.user.repository.document;

import org.adaschool.user.controller.dto.UserDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User
{
    @Id
    private String id;

    private String name;

    private String email;

    public User()
    {
    }

    public User( String id, String name, String email )
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User( UserDto userDto )
    {
        this.name = userDto.getName();
        this.email = userDto.getEmail();
    }

    public String getId()
    {
        return id;
    }


    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail( String email )
    {
        this.email = email;
    }
}
