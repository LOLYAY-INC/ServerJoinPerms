package io.lolyay.serverJoinPerms;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.connection.PostLoginEvent;
import com.velocitypowered.api.event.connection.PreTransferEvent;
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
    private void serverSwitchEvent(PreTransferEvent event){
        if(!event.player().hasPermission("server." + event.player().getCurrentServer().get().getServerInfo().getName()))
        {
            event.player().disconnect(
                    Component.text("You don't have permission to join this server!")
                            .color(NamedTextColor.DARK_RED)
                            .decorate(TextDecoration.BOLD)
            );
        }
    }
}
