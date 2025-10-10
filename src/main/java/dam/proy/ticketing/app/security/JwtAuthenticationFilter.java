package dam.proy.ticketing.app.security;

import dam.proy.ticketing.app.models.Usuario;
import dam.proy.ticketing.app.services.interfaces.IUsuarioService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private IUsuarioService usuarioService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        //Primero verificamos que el usuario exista y empiece con "Bearer" y despues eliminamos el bearer para dejar solo el token

        if (header != null && header.startsWith("Bearer ")) {
            String token = header.substring(7);

            String email = jwtUtil.obtenerEmail(token);

            /*Si no tenemos una autorizacion previa buscamos el usuario en la base de datos y lo validamos creando un token de validacion e insertandoselo
            al usuario.*/

            if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                Usuario usuario = usuarioService.buscarPorEmail(email);

                if (jwtUtil.validarToken(token)) {

                    CustomUserDetails userDetails = new CustomUserDetails(usuario);

                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
