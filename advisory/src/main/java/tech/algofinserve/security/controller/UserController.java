package tech.algofinserve.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.algofinserve.security.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserValidator userValidator;
    private final UserService userService;
    private final UserMapper userMapper;
    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }
    @PostMapping(path= "/register" , consumes = "application/json")
    public ResponseEntity<?> registerUser(@RequestBody UserSignUpRequest userSignUpRequest, BindingResult bindingResult) {

        if(!userService.verifyPassword(userSignUpRequest)){

            return new ResponseEntity<String>(
                    "Password and Password Confirm Not Matching", HttpStatus.EXPECTATION_FAILED);

        }

        UserPersistable userPersistable=userMapper.mapUserSignUpRequestToUserPersistable(userSignUpRequest);
        userPersistable.setUsername(userSignUpRequest.getMobileNumber());

        userValidator.validate(userPersistable, bindingResult);
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors().toString());
            return new ResponseEntity(bindingResult.getAllErrors(), HttpStatus.BAD_REQUEST);
        }

        userService.save(userPersistable);
        return ResponseEntity.ok("User registered successfully");
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginModel loginModel) {
        // Perform authentication logic
        // Return appropriate response or token
        return ResponseEntity.ok("Login successful");
    }
    @PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestBody LoginModel loginModel) {
        // Perform logout logic
        // Invalidate token or session
        return ResponseEntity.ok("Logout successful");
    }
}
