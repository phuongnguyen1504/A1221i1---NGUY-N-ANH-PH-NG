package vn.sprint2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.sprint2.repository.ICustomerRepository;
import vn.sprint2.security.JwtUtil;
import vn.sprint2.service.IAccountService;

@RestController
@CrossOrigin
@RequestMapping("api/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenManager;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private IAccountService accountService;
    @PostMapping("/login")
    public ResponseEntity<JwtResponse>
}
