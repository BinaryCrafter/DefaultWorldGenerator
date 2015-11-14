package com.fireball1725.defaultworldgenerator.proxy;
import com.fireball1725.defaultworldgenerator.config.ConfigGeneralSettings;
import com.fireball1725.defaultworldgenerator.config.ConfigurationFile;
import com.fireball1725.defaultworldgenerator.events.GuiEvents;
import com.fireball1725.defaultworldgenerator.lib.Log;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.world.WorldType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

public class ProxyClient extends Proxy
{
	public static Configuration configuration;

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		configuration = ConfigurationFile.init(event.getSuggestedConfigurationFile());
		MinecraftForge.EVENT_BUS.register(new GuiEvents());
	}

	@Override
	public void init(FMLInitializationEvent event) {
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
		if (ConfigGeneralSettings.generalShowDebugWorldGenerators) {
			Log.info("=======================[ World Generators ]=======================");
			for (int i = 0; i < WorldType.worldTypes.length; i++) {
				if (WorldType.worldTypes[i] != null && WorldType.worldTypes[i].getCanBeCreated()) {
					Log.info("Name: " + WorldType.worldTypes[i].getWorldTypeName());
				}
			}
			Log.info("==================================================================");
		}
	}
}


