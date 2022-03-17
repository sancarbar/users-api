package org.adaschool.user.controller;

import org.adaschool.user.controller.dto.UserDto;
import org.adaschool.user.repository.UserRepository;
import org.adaschool.user.repository.document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping( "/v1/user" )
public class UserController
{

    private final UserRepository userRepository;

    public UserController( @Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @PostMapping()
    public ResponseEntity<User> create( @RequestBody UserDto userDto )
    {
        User user = userRepository.save( new User( userDto ) );
        return ResponseEntity.ok( user );
    }

    @GetMapping( "/{id}" )
    public ResponseEntity<User> findById( @PathVariable String id )
    {
        Optional<User> optionalUser = userRepository.findById( id );
        if ( optionalUser.isPresent() )
        {
            return ResponseEntity.ok( optionalUser.get() );
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }

}
