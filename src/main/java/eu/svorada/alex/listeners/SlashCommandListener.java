package eu.svorada.alex.listeners;

import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import eu.svorada.alex.commands.SlashCommand;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;
import java.util.List;

@Component
public class SlashCommandListener {
  private final Collection<SlashCommand> commands;

  public SlashCommandListener(List<SlashCommand> commands, GatewayDiscordClient client) {
    this.commands = commands;

    client.on(ChatInputInteractionEvent.class, this::handle).subscribe();
  }

  public Mono<Void> handle(ChatInputInteractionEvent event) {
    return Flux.fromIterable(commands)
      .filter(command -> command.getName().equals(event.getCommandName()))
      .next()
      .flatMap(command -> command.handle(event));
  }
}
