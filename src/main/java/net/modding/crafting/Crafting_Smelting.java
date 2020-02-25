package net.modding.crafting;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.modding.registry.Benennung_Registry;

public class Crafting_Smelting extends Benennung_Registry{
		
	public Goldrezepte_Smelting goldRezepte;
	public Eisenrezepte_Smelting eisenRezepte;
	public Holzrezepte_Smelting holzRezepte;
	
	private Goldrezepte_Smelting gold = goldRezepte;
	private Eisenrezepte_Smelting eisen = eisenRezepte;
	private Holzrezepte_Smelting holz = holzRezepte;
	
	public void RegisterCrafting() {
		gold = new Goldrezepte_Smelting();
		eisen = new Eisenrezepte_Smelting();
		holz = new Holzrezepte_Smelting();
		
		gold.GoldCrafting();
		eisen.EisenCrafting();
		holz.HolzCrafting();
	}
	
	public void RegisterSmelting() {
		ItemSmelting(horse_raw, horse_cooked, 3);
		
		gold.GoldSmelting();
		eisen.EisenSmelting();
		holz.HolzSmelting();
	}
	
	public void ItemRecipe(Item out, String r1, String r2, String r3, char buchstabe, Item in) {
		GameRegistry.addRecipe(new ItemStack(out), r1, r2, r3, buchstabe, in);
	}
	
	public void BlockRecipe(Block out, Object... rezept) {
		GameRegistry.addRecipe(new ItemStack(out), rezept);
	}
	
	public void MultipleItemRecipe(Item out, Object... rezept) {
		GameRegistry.addRecipe(new ItemStack(out), rezept);
	}
	
	public void ShapedRecipe (Item out, Object... rezept) {
		GameRegistry.addShapedRecipe(new ItemStack(out), rezept);
	}
	
	public void ShapedMetaRecipe (Item out, int meta, Object... rezept) {
		GameRegistry.addShapedRecipe(new ItemStack(out, 1, meta), rezept);
	}
	
	public void ShapedBlockRecipe(Block out, Object... rezept) {
		GameRegistry.addShapedRecipe(new ItemStack(out), rezept);
	}
	
	public void ShapedIntRecipe (Item out, int menge, Object... rezept) {
		GameRegistry.addShapedRecipe(new ItemStack(out, menge), rezept);
	}
	
	public void ShapedIntBlockRecipe(Block out, int anzahl, Object... rezept) {
		GameRegistry.addShapedRecipe(new ItemStack(out, anzahl), rezept);
	}
	
	public void ShapedBlockMetaRecipe (Block out, int meta, Object... rezept) {
		GameRegistry.addShapedRecipe(new ItemStack(out, 1, meta), rezept);
	}
	
	public void ShapelessRecipe(Item out, Object... in) {
		GameRegistry.addShapelessRecipe(new ItemStack(out), in);
	}
	
	public void ShapelessBlockRecipe(Block out, Object... in) {
		GameRegistry.addShapelessRecipe(new ItemStack(out), in);
	}
	
	public void ShapelessIntRecipe(Item out, int menge, Object... in) {
		GameRegistry.addShapelessRecipe(new ItemStack(out, menge), in);
	}
	
	public void ShapelessIntBlockRecipe(Block out, int menge, Object... in) {
		GameRegistry.addShapelessRecipe(new ItemStack(out, menge), in);
	}
	
	public void ShapelessBlockMetaRecipe(Block out, int meta, Object... in) {
		GameRegistry.addShapelessRecipe(new ItemStack(out, 1, meta), in);
	}
	
	public void ItemSmelting(Item in, Item out, float xp) {
		GameRegistry.addSmelting(in, new ItemStack(out), xp);
	}
	
	public void BlockSmelting(Block in, Item out, float xp) {
		GameRegistry.addSmelting(in, new ItemStack(out), xp);
	}
	
	public void BlockSmelting(Block in, int menge, int meta, Item out, float xp) {
		GameRegistry.addSmelting(new ItemStack(in, menge, meta), new ItemStack(out), xp);
	}
	
	public void HinUndRuck (Item geteert, Item nichtGeteert) {
		ShapedRecipe(geteert, "w", "g", 'w', holz.teer_eimer, 'g', nichtGeteert);
		ShapedRecipe(nichtGeteert, "w", "g", 'w', Items.WATER_BUCKET, 'g', geteert);
	}
	
	public void BlockHinUndRuck (Block geteert, Block nichtGeteert) {
		ShapedBlockRecipe(geteert, "w", "g", 'w', holz.teer_eimer, 'g', nichtGeteert);
		ShapedBlockRecipe(nichtGeteert, "w", "g", 'w', Items.WATER_BUCKET, 'g', geteert);
	}
	
	public void BlockMetaHinUndRuck (Block geteert, int length, Block nichtGeteert) {
		for (int meta=0; meta < length; meta++) {
		ShapedBlockMetaRecipe(geteert, meta, new Object[]{"w", "g", 'w', holz.teer_eimer, 'g', new ItemStack(nichtGeteert, 1, meta)});
		ShapedBlockMetaRecipe(nichtGeteert, meta, new Object[]{"w", "g", 'w', Items.WATER_BUCKET, 'g', new ItemStack(geteert, 1, meta)});
		}
	}
	
	public void MetaHinUndRuck (Item geteert, int length, Block nichtGeteert) {
		for (int meta=0; meta < length; meta++) {
		ShapedMetaRecipe(geteert, meta, new Object[]{"w", "g", 'w', holz.teer_eimer, 'g', new ItemStack(nichtGeteert, 1, meta)});
		ShapedBlockMetaRecipe(nichtGeteert, meta, new Object[]{"w", "g", 'w', Items.WATER_BUCKET, 'g', new ItemStack(geteert, 1, meta)});
		}
	}
	
	public void ToolRezepte (Object toolReihe, Item schaufel, Item schwert, Item pickaxe, Item axe, Item hoe) {
		ShapedRecipe(schaufel, "t", "h", "h", 't', toolReihe, 'h', Items.STICK);
		ShapedRecipe(schwert, "t", "t", "h", 't', toolReihe, 'h', Items.STICK);
		MultipleItemRecipe(pickaxe, "ttt", " h ", " h ", 't', toolReihe, 'h', Items.STICK);
		ShapedRecipe(axe, "tt", " h", " h", 't', toolReihe, 'h', Items.STICK);
		ShapedRecipe(hoe, "pp", "ps", " s", 'p', toolReihe, 's', Items.STICK);
	}
	
	public void ArmorRezepte (Item armorReihe, Item chestplate, Item leggings, Item boots, Item helmet) {
		ItemRecipe(chestplate, "s s", "sss", "sss", 's', armorReihe);
		ItemRecipe(leggings, "sss", "s s", "s s", 's', armorReihe);
		ShapedRecipe(boots, "s s", "s s", 's', armorReihe);
		ShapedRecipe(helmet, "sss", "s s", 's', armorReihe);
	}
	
}
