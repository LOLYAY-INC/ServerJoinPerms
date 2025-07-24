package io.lolyay.serverJoinPerms;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import com.velocitypowered.api.event.connection.PreTransferEvent;
import com.velocitypowered.api.event.player.ServerPreConnectEvent;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;

public class EventHandler {
    @Subscribe
    private void preLoginEvent(PostLoginEvent event){
        if(event.getPlayer().getCurrentServer().isEmpty()) return;
        if(!event.getPlayer().hasPermission("server." + event.getPlayer().getCurrentServer().get().getServerInfo().getName()))
        {
            event.getPlayer().disconnect(
                    Component.text("You don't have permission to join this server!")
                            .color(NamedTextColor.DARK_RED)
                            .decorate(TextDecoration.BOLD)
            );
        }
    }

    @Subscribe
    private void serverPreConnect(ServerPreConnectEvent event){
        if(!event.getPlayer().hasPermission("server." + event.getOriginalServer().getServerInfo().getName()))
        {
            event.getPlayer().sendMessage(
                    Component.text("You don't have permission to join this server!")
                            .color(NamedTextColor.DARK_RED)
                            .decorate(TextDecoration.BOLD)
            );

            event.setResult(ServerPreConnectEvent.ServerResult.denied());
            if(event.getPreviousServer() == null){
                event.getPlayer().disconnect(
                        Component.text("You don't have permission to join this server!")
                                .color(NamedTextColor.DARK_RED)
                                .decorate(TextDecoration.BOLD)
                );
            }
        }
    }
}
