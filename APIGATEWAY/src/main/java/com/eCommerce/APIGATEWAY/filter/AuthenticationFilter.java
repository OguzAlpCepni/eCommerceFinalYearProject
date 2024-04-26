package com.eCommerce.APIGATEWAY.filter;

import com.eCommerce.APIGATEWAY.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFilter extends AbstractGatewayFilterFactory<AuthenticationFilter.Config> {

    @Autowired
    private RouteValidator validator;
    @Autowired
    private JwtUtil jwtUtil;
    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            if(validator.isSecured.test(exchange.getRequest())){
                //Header contains token or not
                if(!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)){
                    throw  new RuntimeException("missing outhorization header");
                }
                String authHeader = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                if(authHeader!=null&&authHeader.startsWith("Bearer ")){
                    authHeader=authHeader.substring(7);
                }
                try{
                    //REST CALL TO AUTH SERVİCE
                    //restTemplate.getForObject("http://AuthenticationService//validate?token"+authHeader,String.class);
                    jwtUtil.validateToken(authHeader);

                }catch (Exception e){
                    System.out.println("invalid access....!");
                    throw new RuntimeException("un authorized access to application");
                }
            }
            return chain.filter(exchange);
        });
    }

    public AuthenticationFilter() {
        super(Config.class);
    }

    public static class Config{

    }
}
