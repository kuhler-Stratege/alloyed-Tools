package net.modding.crafting;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.modding.blocks.holzlackierung.BlockTeerFenceGate;
import net.modding.blocks.holzlackierung.BlockTeerTreppe;
import net.modding.blocks.holzlackierung.BlockTeerZaun;
import net.modding.blocks.holzlackierung.metadata.TeerTypes;
import net.modding.main.modding;
import net.modding.registry.Holzlackierung;

public class Holzrezepte_Smelting extends Holzlackierung {

	private Crafting_Smelting c = modding.rezepte;
	private static int length = TeerTypes.length;
	
	public void HolzCrafting() {
		
		//Holzlackierung
		c.HinUndRuck(teer_stick, Items.STICK);
		c.BlockHinUndRuck(teer_knopf, Blocks.WOODEN_BUTTON);
		c.BlockHinUndRuck(teer_pressure_plate, Blocks.WOODEN_PRESSURE_PLATE);
		c.ShapedIntRecipe(teer_stick, 4, "p", "p", 'p', plank_teer);
		c.ShapedRecipe(kohle_eimer, "k", "e", 'k', new ItemStack(Items.COAL, 1, 0), 'e', Items.BUCKET);
		c.ShapedRecipe(kohle_eimer, "k", "e", 'k', new ItemStack(Items.COAL, 1, 1), 'e', Items.BUCKET);
		c.ShapedBlockRecipe(teer_pressure_plate, "pp", 'p', plank_teer);
		
		
			//Plank Teers
			c.BlockMetaHinUndRuck(plank_teer, length, Blocks.PLANKS);
			
			//alles mit Plank Teer Anteil
			c.MetaHinUndRuck(itemblockTeerHalfSlab, length, Blocks.WOODEN_SLAB);
			for (int meta=0; meta < length; meta++) { 
				GameRegistry.addShapedRecipe(new ItemStack(itemblockTeerHalfSlab, 6, meta), new Object[]{"ggg", 'g', new ItemStack(plank_teer, 1, meta)});
				c.ShapelessBlockRecipe(teer_knopf, new ItemStack(plank_teer, 1, meta));
				c.ShapedIntBlockRecipe(teer_zaun, 3, new Object[] {"psp", "psp", 'p', new ItemStack(plank_teer, 1, meta), 's', new ItemStack(teer_stick)});
				c.ShapedBlockRecipe(teer_fence_gate, new Object[] {"sps", "sps", 'p', new ItemStack(plank_teer, 1, meta), 's', new ItemStack(teer_stick)});
				c.ShapedBlockRecipe(teer_treppe, new Object[] {"ppp", "pp", "p", 'p', new ItemStack(plank_teer, 1, meta)});
				}
			
			//Arrays
			Block[] treppenArray = BlockTeerTreppe.getTreppenArray();
			Block[] zaunArray = BlockTeerZaun.getZaunArray();
			Block[] zauntorArray = BlockTeerFenceGate.getFenceGateArray();
			
			for (int i=0; i<treppenArray.length; i++) {
			c.ShapedBlockRecipe(teer_treppe, "w", "g", 'w', holz.teer_eimer, 'g', new ItemStack(treppenArray[i]));
			c.ShapedBlockRecipe(treppenArray[i], "w", "g", 'w', Items.WATER_BUCKET, 'g', teer_treppe);
			}
			
			for (int i=0; i<zaunArray.length;i++) {
				c.ShapedBlockRecipe(teer_treppe, "w", "g", 'w', holz.teer_eimer, 'g', new ItemStack(zaunArray[i]));
				c.ShapedBlockRecipe(zaunArray[i], "w", "g", 'w', Items.WATER_BUCKET, 'g', teer_treppe);
			}
			
			for (int i=0; i<zauntorArray.length;i++) {
			c.ShapedBlockRecipe(teer_fence_gate, "w", "g", 'w', holz.teer_eimer, 'g', new ItemStack(zauntorArray[i]));
			c.ShapedBlockRecipe(zauntorArray[i], "w", "g", 'w', Items.WATER_BUCKET, 'g', teer_fence_gate);
			}
			
			c.ToolRezepte(plank_teer, teer_shovel, teer_sword, teer_pickaxe, teer_axe, teer_hoe);
			
			c.HinUndRuck(teer_axe, Items.WOODEN_AXE);
			c.HinUndRuck(teer_shovel, Items.WOODEN_SHOVEL);
			c.HinUndRuck(teer_sword, Items.WOODEN_SWORD);
			c.HinUndRuck(teer_pickaxe, Items.WOODEN_PICKAXE);
			c.HinUndRuck(teer_hoe, Items.WOODEN_HOE);
			
			c.ArmorRezepte(sohlleder, teer_chestplate, teer_leggings, teer_boots, teer_helmet);
	}	
	
	public void HolzSmelting() {
		c.ItemSmelting(kohle_eimer, teer_eimer, 5);
	}
}