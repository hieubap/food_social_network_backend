package spring.boot.food.social.network;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"spring.boot.core","spring.boot.food.social.network"})
public class FoodSocialNetworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodSocialNetworkApplication.class, args);
    }

}
