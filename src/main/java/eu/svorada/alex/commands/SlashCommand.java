package eu.svorada.alex.commands;

import discord4j.core.event.domain.interaction.ChatInputInteractionEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

public interface SlashCommand {

  String getName();

  Mono<Void> handle(ChatInputInteractionEvent event);
}
