package eu.svorada.alex;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.object.presence.ClientActivity;
import discord4j.core.object.presence.ClientPresence;
import discord4j.rest.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBot {

  @Value("${token}")
  private String token;

  public static void main(String[] args) {
    new SpringApplicationBuilder(SpringBot.class)
      .build()
      .run(args);
  }

  @Bean
  public GatewayDiscordClient gatewayDiscordClient() {
    return DiscordClientBuilder.create(token).build()
      .gateway()
      .setInitialPresence(ignore -> ClientPresence.online(ClientActivity.listening("to /commands")))
      .login()
      .block();
  }

  @Bean
  public RestClient discordRestClient(GatewayDiscordClient client) {
    return client.getRestClient();
  }

}