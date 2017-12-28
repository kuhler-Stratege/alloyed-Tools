package net.modding.main;

import java.net.URL;
import java.util.List;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.*;
import cpw.mods.fml.common.Mod.*;
import cpw.mods.fml.common.event.*;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.modding.proxy.ServerProxy;
import net.modding.util.*;
import net.modding.crafting.Crafting_Smelting;
import net.modding.fludis.BucketHandler;
import net.modding.generations.BlockGenerator;
import net.modding.items.LootTables;

@Mod(modid = modding.MODID, version = modding.VERSION, name = modding.NAME, canBeDeactivated = true)

public class modding{

	public static final String MODID = "modding";
	public static final String VERSION = "0.5.1";
	public static final String NAME = "alloyed tools";
	
	
	@SidedProxy(modId = modding.MODID, clientSide = "net.modding.proxy.ClientProxy", serverSide = "net.modding.proxy.ServerProxy")
	public static ServerProxy proxy;
	
	public static McMod_info modInfo;
	public static Benennung_Registry registry;
	public static Crafting_Smelting rezepte = new Crafting_Smelting();	
	
	@Instance
	public static modding instance;
			
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		UpdateChecker.checkForUpdates();

		registry = new Benennung_Registry();
		registry.Benennung();
		registry.ClientOnly(event);
		registry.Registry();
		
	}
			
	@EventHandler
	public void init(FMLInitializationEvent event) {
	
		rezepte.RegisterCrafting();
		rezepte.RegisterSmelting();
				
		MinecraftForge.EVENT_BUS.register(new LootTables());	
		MinecraftForge.EVENT_BUS.register(new Events());
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		proxy.RegisterClientStuff();
		proxy.RegisterEimer();
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent event) {
		GameRegistry.registerWorldGenerator(new BlockGenerator(), 1);
	}
	
}	