package com.usuario.pragma.emason.infrastructure.jwt;

import com.usuario.pragma.emason.application.handler.JwtHandler;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtHandler jwtHandler;
    private final UserDetailsService userDetailsService;



    /**
     * Same contract as for {@code doFilter}, but guaranteed to be
     * just invoked once per request within a single request thread.
     * See {@link #shouldNotFilterAsyncDispatch()} for details.
     * <p>Provides HttpServletRequest and HttpServletResponse arguments instead of the
     * default ServletRequest and ServletResponse ones.
     *
     * @param request
     * @param response
     * @param filterChain
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        final String token = getTokenFromRequest(request);
        final String email;
        System.out.println("-------Token:" + token);;
        System.out.println("request "+request);

        if(token == null){
            filterChain.doFilter(request, response);
            System.out.println("Token is null ##############################################################################################################################");
            return;
        }
        email = jwtHandler.getEmailFromToken(token);
        System.out.println("Email jwt: "+email);
        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){

            System.out.println("security "+SecurityContextHolder.getContext().getAuthentication());
            UserDetails userDetails = userDetailsService.loadUserByUsername(email);

            System.out.println("UserDetails: "+userDetails.getUsername());
            System.out.println("UserDetails: "+userDetails.getPassword());
            System.out.println("UserDetails: "+userDetails.getAuthorities());


            if(jwtHandler.isTokenValid(token, userDetails)){
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        userDetails,
                        null,
                        userDetails.getAuthorities()
                );

                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);

            }

        }
        filterChain.doFilter(request, response);
    }




    private String getTokenFromRequest(HttpServletRequest request){
        //final String bearerToken = request.getHeader("Authorization");
        final String bearerToken = request.getHeader("Authorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7);
        }

        return null;
    }
}
