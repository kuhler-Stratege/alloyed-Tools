package net.modding.main;

import java.io.File;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLLoadCompleteEvent;
import net.minecraftforge.fml.common.event.FMLLoadEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.modding.blocks.holzlackierung.BlockTeerFenceGate;
import net.modding.blocks.holzlackierung.BlockTeerTreppe;
import net.modding.blocks.holzlackierung.BlockTeerZaun;
import net.modding.crafting.Crafting_Smelting;
import net.modding.fluids.BucketHandler;
import net.modding.generations.BlockGenerator;
import net.modding.items.LootTables;
import net.modding.items.holzlackierung.TeerFuelHandler;
import net.modding.proxy.ClientProxy;
import net.modding.proxy.ServerProxy;
import net.modding.proxy.render.HolzRender;
import net.modding.registry.Benennung_Registry;
import net.modding.util.Events;
import net.modding.util.McMod_info;
import net.modding.util.ModConfiguration;

@Mod(modid = modding.MODID, version = modding.VERSION, name = modding.NAME, canBeDeactivated = false, acceptedMinecraftVersions = modding.MC_VERSIONS)

public class modding{

	public static final String MODID = "modding";
	public static final String NAME = "alloyed tools";
	public static final String VERSION = "0.5.2";
	public static final String BUILDED_MC_VERSION = "1.10.2";
	public static final String MC_VERSIONS = "1.9 - 1.10.2";
	
	@SidedProxy(modId = modding.MODID, clientSide = "net.modding.proxy.ClientProxy", serverSide = "net.modding.proxy.ServerProxy")
	public static ServerProxy proxy;
	
	public static McMod_info modInfo;
	public static Benennung_Registry registry;
	public static Crafting_Smelting rezepte;
	public static Configuration modConfig;
	public static ModConfiguration configClass;
	public static Logger logger;
	public static File jarFile;
	public static File minecraftFile;
	public static Properties startbedingungen;
	public static String modBeschreibung;
	
	static {
		FluidRegistry.enableUniversalBucket();
	}
	
	//TODO Villagerrezepte hinzufügen, Methodenbeschreibungen schreiben, Diamanten verbessern als Hauptthema
	
	@Instance (modding.MODID)
	public static modding instance;
	
	@EventHandler
	public void startLoading (FMLLoadEvent event) {
		
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger =  event.getModLog();
		logger.info("start building alloyed Tools.");
		
		logger.info("creating alloyed Tools config.");
		configClass = new ModConfiguration();
		configClass.createConfig(event);
		logger.info("done creating alloyed Tools config.");
		
		registry = new Benennung_Registry();
		registry.Benennung();
		registry.ClientOnly(event);
		registry.Registry();
		
		jarFile = event.getSourceFile();
		minecraftFile = event.getModConfigurationDirectory();
		startbedingungen = event.getVersionProperties();
		modBeschreibung = event.description();
	}
			
	@EventHandler
	public void init(FMLInitializationEvent event) {
	
		modConfig = configClass.getConfig();
		
		rezepte = new Crafting_Smelting();
		rezepte.RegisterCrafting();
		rezepte.RegisterSmelting();
			
		GameRegistry.registerWorldGenerator(new BlockGenerator(registry.gold.platin_ore.getDefaultState(), 7, 14, configClass.getPlatinHohe()), 5);
		GameRegistry.registerWorldGenerator(new BlockGenerator(registry.eisen.chrom_ore.getDefaultState(), 11, 6, configClass.getChromHohe()), 3);
		
		GameRegistry.registerFuelHandler(new TeerFuelHandler());
		
		MinecraftForge.EVENT_BUS.register(new LootTables());
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
		MinecraftForge.EVENT_BUS.register(new Events());
		MinecraftForge.EVENT_BUS.register(new HolzRender());
		MinecraftForge.EVENT_BUS.register(registry.holz.blockFluidTeer);
		MinecraftForge.EVENT_BUS.register(new ClientProxy());
		
		proxy.RenderTextures();
		proxy.renderEimer();
		proxy.renderTeer(event);
		
	}
	
	@EventHandler
	public void postInit (FMLPostInitializationEvent event) {
			try {
				BlockTeerZaun.fulleZaunArray();
				logger.info("Zaunarray gefuellt");
				BlockTeerFenceGate.fulleFenceGateArray();
				logger.info("Zauntorarray gefuellt");
				BlockTeerTreppe.fulleTreppenArray();
				logger.info("Treppenarray gefuellt");
				} catch (NullPointerException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				}
			}
	
	@EventHandler
	public void doneLoading (FMLLoadCompleteEvent event) {
		logger.info("done Building alloyed Tools.");
	}
	
	public void sayln (String woerter) {
		System.out.println(woerter);
	}
	
	public void say (String woerter) {
		System.out.print(woerter);
	}
	
	public static void sayStaticln (String woerter) {
		System.out.println(woerter);
	}
	
	public static void sayStatic (String woerter) {
		System.out.print(woerter);
	}
	
}	