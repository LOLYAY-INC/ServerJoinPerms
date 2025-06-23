package io.lolyay.serverJoinPerms;

import com.google.inject.Inject;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.plugin.annotation.DataDirectory;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

import java.nio.file.Path;

@Plugin(id = "serverjoinperms", name = "ServerJoinPerms", version = "1.0-ALPHA", authors = {"LOLYAY"})
public class ServerJoinPerms {

    public static ProxyServer proxy;
    public static Logger logger;

    @Inject
    public ServerJoinPerms(ProxyServer server, Logger loggerI, @DataDirectory Path dataDirectory) {
        proxy = server;
        logger = loggerI;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        proxy.getEventManager().register(this, new EventHandler());
    }
}
