package leoguedex.com.github.JavaBankDesenvolvimento.configuration;

import leoguedex.com.github.JavaBankDesenvolvimento.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfiguration {

    @Autowired
    private DBService dbService;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String strategy;

    @Bean
    public boolean instanciaDatabase(){
        if(!"create".equals(strategy)){
            return false;
        }
        dbService.instanciaBancoDeDados();
        return true;
    }


}
