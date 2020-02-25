package net.modding.items;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
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
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class LootTables {

	//All Methods in this class are written by Glitchfiend, Adubbz and Forstride.
	
	public static Benennung_Registry registry = modding.registry;
	
	@SubscribeEvent
	public void LootTableAdd (LootTableLoadEvent event) {
		if (modding.configClass.EasterEggAktiv() == true) {
		newLootTable(LootTableList.ENTITIES_HORSE, registry.horse_raw, 6, 0.75F, 0F, 3F, event);
		}
		newLootTable(LootTableList.ENTITIES_ZOMBIE_PIGMAN, registry.gold.mix_klumpen, 2, 0.6F, 2.1F, 0F, 4F, event);		
		newLootTable(LootTableList.ENTITIES_ZOMBIE_PIGMAN, registry.gold.mix_sword, 1, new LootFunction[] {new SetDamage(new LootCondition[] {new KilledByPlayer(false), new RandomChanceWithLooting(0.3F, 1.2F)}, new RandomValueRange(0.15F, 0.81F))}, new LootCondition[] {new KilledByPlayer(false), new RandomChanceWithLooting(0.3F, 1.2F)}, "mix_sword", event);
		newLootTable(LootTableList.ENTITIES_COW, registry.holz.sohlleder, 2, 0.45F, 0F, 2F, event);
		newLootTable(LootTableList.ENTITIES_MUSHROOM_COW, registry.holz.sohlleder, 3, 0.6F, 0F, 2F, event);	
	}
	
	public void newLootTable (ResourceLocation entity, Item droppedItem, int anzahl, float randomChance, float randomValueMin, float randomValueMax, LootTableLoadEvent event) {
	if (event.getName().equals(entity))
	{ 
        LootPool main = event.getTable().getPool("main");
        if (main != null)
        {
            main.addEntry(new LootEntryItem(droppedItem, anzahl, 0, new LootFunction[] {new SetCount( new LootCondition[] {new RandomChance(randomChance)}, new RandomValueRange(randomValueMin, randomValueMax))}, new LootCondition[] {new RandomChance(randomChance)}, modding.MODID + ":" + droppedItem.getUnlocalizedName().substring(5)));
        }
	  }
	}
	
	public void newLootTable (ResourceLocation entity, Item droppedItem, int anzahl, float randomChance, float lootingMuliplier, float randomValueMin, float randomValueMax, LootTableLoadEvent event) {
		if (event.getName().equals(entity))
		{
            LootPool main = event.getTable().getPool("main");
            if (main != null)
            {
                main.addEntry(new LootEntryItem(droppedItem, anzahl, 0, new LootFunction[] {new SetCount(new LootCondition[] {new RandomChanceWithLooting(randomChance, lootingMuliplier)}, new RandomValueRange(randomValueMin, randomValueMax))}, new LootCondition[] {new RandomChanceWithLooting(randomChance, lootingMuliplier)} , modding.MODID + ":" + droppedItem.getUnlocalizedName().substring(5)));
            }
		  }
	}
	
	public void newLootTable (ResourceLocation entity, Item droppedItem, int anzahl, LootFunction[] funktion, LootCondition[] kondition, String name, LootTableLoadEvent event) {
		if (event.getName().equals(entity))
		{
            LootPool main = event.getTable().getPool("main");
            if (main != null)
            {
                main.addEntry(new LootEntryItem(droppedItem, anzahl, 0, funktion, kondition, modding.MODID + ":" + name));
            }
		  }
	}
}