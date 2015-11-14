package com.fireball1725.defaultworldgenerator;
import com.fireball1725.defaultworldgenerator.lib.Reference;
import com.fireball1725.defaultworldgenerator.proxy.Proxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION_BUILD)
public class DefaultWorldGenerator {
    @Mod.Instance
    public static DefaultWorldGenerator instance;

    @SidedProxy(serverSide="com.fireball1725.defaultworldgenerator.proxy.ProxyServer", clientSide = "com.fireball1725.defaultworldgenerator.proxy.ProxyClient")
    public static Proxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
