package fr.eni.encheres2.security.auth;

import fr.eni.encheres2.security.jwt.JwtService;
import fr.eni.encheres2.security.userInfo.UserInfo;
import fr.eni.encheres2.security.userInfo.UserInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class AuthService {

    private UserInfoRepository userInfoRepository;
    private AuthenticationManager authenticationManager;
    private JwtService jwtService;

    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getPseudo(), request.getPassword()));
        UserInfo user = userInfoRepository.findById(request.getPseudo()).orElseThrow();
        String jwtToken = jwtService.generateToken(user);
        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(jwtToken);
        return authResponse;
    }

}
