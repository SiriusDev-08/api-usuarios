package com.projetogreat.APIusuarios.controller;

import com.projetogreat.APIusuarios.model.User;
import com.projetogreat.APIusuarios.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j

public class UserController {
    UserService userService;

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        log.info("Criando um novo usuário com  as informações: [{}]", user);
        return userService.createUser(user);
    }

    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)

    public List<User> getAllUsers(){
        log.info("Listando todos os usuários cadastrados: ");
        return userService.listAllUsers();
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)

    public ResponseEntity<User> getUserById(@PathVariable (value = "id") Long id){
        log.info("Buscando usuário com o id [{}]", id);
        return userService.findUserById(id);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)

    public ResponseEntity<User> getsUserById(@PathVariable (value = "id") Long id, @RequestBody User user){
        log.info("Atualizando a tarefa com o id [{}] as novas informações são : [{}]", id,  user);
        return userService.updateUserById(user, id);
    }

    @DeleteMapping ("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Object> deleteUserById (@PathVariable (value = "id") Long id){
        log.info("Excluindo usuário com o id [{}]", id);
        return userService.deleteById(id);
    }
}