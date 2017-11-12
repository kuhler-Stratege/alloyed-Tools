package net.modding.main;

import java.net.URL;
import java.util.List;

import com.google.common.collect.Lists;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.ModMetadata;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.modding.proxy.ServerProxy;
import net.modding.util.Events;
import net.modding.util.McMod_info;
import net.modding.util.UpdateChecker;
import net.modding.crafting.Crafting_Smelting;
import net.modding.fludis.BucketHandler;
import net.modding.generations.BlockGenerator;
import net.modding.generations.BlockGenerator_2;
import net.modding.items.LootTables;

@Mod(modid = modding.MODID, version = modding.VERSION, name = modding.NAME, canBeDeactivated = true)

public class modding{

	public static final String MODID = "modding";
	public static final String VERSION = "0.5";
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
			
		GameRegistry.registerWorldGenerator(new BlockGenerator(registry.platin_ore.getDefaultState(), 7, 14), 5);
		GameRegistry.registerWorldGenerator(new BlockGenerator_2(registry.chrom_ore.getDefaultState(), 11, 6), 3);
		
		MinecraftForge.EVENT_BUS.register(new LootTables());	
		MinecraftForge.EVENT_BUS.register(new Events());
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		proxy.RegisterClientStuff();
		proxy.RegisterEimer();
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent event) {
		
	}
	
}	