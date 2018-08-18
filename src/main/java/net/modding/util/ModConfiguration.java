package net.modding.util;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.modding.main.modding;

public class ModConfiguration extends modding {

	private static Configuration config;
	
	private static boolean sollSuchen = true;
	
	private static boolean easterEgg;
	
	private static int hohePlatin;
	private static int hoheChrom;
	
	public static void createConfig(FMLPreInitializationEvent preInit) {
		config = new Configuration(preInit.getSuggestedConfigurationFile());
		config.load();
		
		config.setCategoryComment("UpdateChecker", "Here you have a few options for the UpdateChecker.");
		sollSuchen = config.getBoolean("should UpdateChecker run", "UpdateChecker", true, "should the UpdateChecker search for a newer mod version?");
		
		config.setCategoryComment("WorldGeneration", "Here you can change the spawn height of the ores, added with this mod.");
		hohePlatin = config.getInt("Platin Spawn Height", "WorldGeneration", 30, 3, 60, "at what height (Y-Koordinate) should platin ore spawn?");
		hoheChrom = config.getInt("Chromite Spawn Height", "WorldGeneration", 17, 3, 60, "at what height (Y-Koordinate) should chromite ore spawn?");
		
		easterEgg = config.getBoolean("enable Easteregg", "Drops", true, "should the Easteregg being aktivated?");
		
		if (config.hasChanged()) {
			config.save();		
		}
	}
	
	public static Configuration getConfig() {
		return config;
	}
	
	public static boolean SollSuchen() {
		return sollSuchen;
	}
	
	public static int getPlatinHohe() {
		return hohePlatin;
	}
	
	public static int getChromHohe() {
		return hoheChrom;
	}
	
	public static boolean EasterEggAktiv() {
		return easterEgg;
	}
}
