package net.modding.blocks.holzlackierung;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class BasicBlockTeer extends Block{

	public static Benennung_Registry registry = modding.registry;
	
	public BasicBlockTeer(String name, Material material, int level, float harte, SoundType sound) {
		super(material);
		setBlockName(name);
		setCreativeTab(registry.teerTab);
		setHarvestLevel("axe", level);
		setHardness(harte);
		setStepSound(sound);
		setBlockTextureName(modding.MODID + ":" + name);
		//Holz, Gold: 0, Stein: 1, Eisen: 2, Diamant: 3
	}
}
