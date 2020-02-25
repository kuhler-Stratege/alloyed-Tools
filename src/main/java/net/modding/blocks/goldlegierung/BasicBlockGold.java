package net.modding.blocks.goldlegierung;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;

public class BasicBlockGold extends Block{

	public Benennung_Registry registry = modding.registry;
	
	public BasicBlockGold(String name, Material material, int level, float harte, SoundType sound, float resistenz) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.platinTab);
		setHarvestLevel("pickaxe", level);
		setHardness(harte);
		setSoundType(sound);
		setResistance(resistenz);
		//Holz, Gold: 0, Stein: 1, Eisen: 2, Diamant: 3
	}
}