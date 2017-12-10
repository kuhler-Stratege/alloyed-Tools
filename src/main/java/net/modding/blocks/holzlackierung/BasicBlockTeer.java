package net.modding.blocks.holzlackierung;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class BasicBlockTeer extends Block{

	public static Benennung_Registry registry = modding.registry;
	
	public BasicBlockTeer(String name, Material material, int level, float harte, SoundType sound, float resistenz) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.teerTab);
		setHarvestLevel("axe", level);
		setHardness(harte);
		setStepSound(sound);
		setResistance(resistenz);
		//Holz, Gold: 0, Stein: 1, Eisen: 2, Diamant: 3
	}
	
	public BasicBlockTeer(String name, Material material, int level, float harte, float resistenz, SoundType sound) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.teerTab);
		setHarvestLevel("axe", level);
		setHardness(harte);
		setStepSound(sound);
		setResistance(resistenz);
	}
}
