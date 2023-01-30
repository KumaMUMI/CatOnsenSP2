package com.example.catonsensp2.Controllers;

import com.example.catonsensp2.Models.ERole;
import com.example.catonsensp2.Models.RoleModel;
import com.example.catonsensp2.Models.UserModel;
import com.example.catonsensp2.Repositories.RoleRepository;
import com.example.catonsensp2.Repositories.UserRepository;
import com.example.catonsensp2.Security.jwt.JwtUtils;
import com.example.catonsensp2.Security.services.UserDetailsImpl;
import com.example.catonsensp2.payload.request.LoginRequest;
import com.example.catonsensp2.payload.request.SignupRequest;
import com.example.catonsensp2.payload.response.MessageResponse;
import com.example.catonsensp2.payload.response.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        String roles = userDetails.getAuthorities().stream().map(item -> item.getAuthority()).toString();

        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, jwtCookie.toString())
                .body(new UserInfoResponse(userDetails.getId(),
                        userDetails.getUsername(),
                        roles));
    }

    @PostMapping("/signout")
    public ResponseEntity<?> logoutUser() {
        ResponseCookie cookie = jwtUtils.getCleanJwtCookie();
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE, cookie.toString())
                .body(new MessageResponse("You've been signed out!"));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

        // Create new user's account
        UserModel user = new UserModel(signUpRequest.getUsername(),encoder.encode(signUpRequest.getPassword()));

        String strRole = signUpRequest.getRole();
        RoleModel role = new RoleModel();

        if (strRole == null) {
            RoleModel userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            role = userRole;
        } else {
            if (strRole == "admin"){
                role.setName(ERole.ROLE_ADMIN);
            } else if (strRole == "user") {
                role.setName(ERole.ROLE_USER);
            }
        }

        user.setRoles(role);
        userRepository.save(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
