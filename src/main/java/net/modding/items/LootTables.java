package net.modding.items;

import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootEntryItem;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.KilledByPlayer;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraft.world.storage.loot.conditions.RandomChance;
import net.minecraft.world.storage.loot.conditions.RandomChanceWithLooting;
import net.minecraft.world.storage.loot.functions.LootFunction;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraft.world.storage.loot.functions.SetDamage;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class LootTables {

	//All Methods in this class are written by Glitchfiend, Adubbz and Forstride.
	
	public static Benennung_Registry registry = modding.registry;
	
	@SubscribeEvent
	public void LootTableAdd (LootTableLoadEvent event) {
		
		if (event.getName().equals(LootTableList.ENTITIES_HORSE))
		{ 
            LootPool main = event.getTable().getPool("main");
            if (main != null)
            {
                main.addEntry(new LootEntryItem(registry.horse_raw, 2, 0, new LootFunction[] {new SetCount( new LootCondition[] {new RandomChance(0.75F)}, new RandomValueRange(0F, 3F))}, new LootCondition[] {new RandomChance(0.75F)}, "modding:horse_raw"));
            }
		  }
		
		
		if (event.getName().equals(LootTableList.ENTITIES_ZOMBIE_PIGMAN))
		{
            LootPool main = event.getTable().getPool("main");
            if (main != null)
            {
                main.addEntry(new LootEntryItem(registry.mix_klumpen, 2, 0, new LootFunction[] {new SetCount(new LootCondition[] {new RandomChanceWithLooting(0.6F, 2.1F)}, new RandomValueRange(0F, 4F))}, new LootCondition[] {new RandomChanceWithLooting(0.6F, 2.1F)} , "modding:mix_klumpen"));
            }
		  }
		
	
		if (event.getName().equals(LootTableList.ENTITIES_ZOMBIE_PIGMAN))
		{
	        LootPool main = event.getTable().getPool("main");
            if (main != null)
            {
                main.addEntry(new LootEntryItem(registry.mix_sword, 1, 0, new LootFunction[] {new SetDamage(new LootCondition[] {new KilledByPlayer(false), new RandomChanceWithLooting(0.3F, 1.2F)}, new RandomValueRange(0.15F, 0.81F))}, new LootCondition[] {new KilledByPlayer(false), new RandomChanceWithLooting(0.3F, 1.2F)}, "modding:mix_sword"));
          }
		}
		
		if (event.getName().equals(LootTableList.ENTITIES_COW))
		{ 
            LootPool main = event.getTable().getPool("main");
            if (main != null)
            {
                main.addEntry(new LootEntryItem(registry.sohlleder, 2, 0, new LootFunction[] {new SetCount( new LootCondition[] {new RandomChance(0.65F)}, new RandomValueRange(0F, 2F))}, new LootCondition[] {new RandomChance(0.45F)}, "modding:sohlleder"));
            }
		}
	}
  
}