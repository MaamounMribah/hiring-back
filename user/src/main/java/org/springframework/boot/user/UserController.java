package org.springframework.boot.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:3001", methods = RequestMethod.POST)
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

//    @PostMapping //Cette annotation indique que la méthode gère les requêtes HTTP de type POST. Cela signifie que cette méthode sera exécutée lorsque votre application recevra une requête POST à l'URL associée à cette méthode
//    @ResponseStatus(HttpStatus.CREATED) //Cette annotation indique que la méthode doit renvoyer une réponse HTTP avec le code d'état "201 Created" si elle s'exécute avec succès. Le code d'état "201 Created" est généralement utilisé pour indiquer que la création de la ressource a été réussie. Vous pouvez personnaliser le code d'état en fonction de vos besoins.
//
//    public void save(@RequestBody User user){ //Cette méthode accepte une instance de la classe User en tant que corps de la requête HTTP. L'annotation @RequestBody indique à Spring de désérialiser automatiquement les données JSON (ou XML, etc.) de la requête HTTP en un objet User. Ensuite, la méthode saveUser(user) de la classe de service
//
//        service.saveUser(user);
//    }

    @PostMapping("/create")//Cette annotation indique que la méthode gère les requêtes HTTP de type POST. Cela signifie que cette méthode sera exécutée lorsque votre application recevra une requête POST à l'URL associée à cette méthode
    @CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User createdUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }


    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:3000", methods = RequestMethod.GET)
    public ResponseEntity<List<User>> findAllUsers(){

        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/getUserById/{userId}")
    @CrossOrigin(origins = "http://localhost:3000") // Remplacez par l'URL de votre frontend React
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

  /*@PutMapping("/UpdateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<List<User>> findUsersByName(@RequestParam("username") String username) {
        List<User> users = userService.findUsersByName(username);
        return ResponseEntity.ok(users);
    }*/

    @DeleteMapping("/deleteUser/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable int userId, @RequestBody User user) {
        User updatedUser = userService.updateUser(userId, user);
        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}






