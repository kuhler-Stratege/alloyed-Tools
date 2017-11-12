package net.modding.blocks.goldlegierung;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class BasicBlockGold extends Block{

	public static Benennung_Registry registry = modding.registry;
	
	public BasicBlockGold(String name, Material material, int level, float harte, SoundType sound) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.platinTab);
		setHarvestLevel("pickaxe", level);
		setHardness(harte);
		setSoundType(sound);
		//Holz, Gold: 0, Stein: 1, Eisen: 2, Diamant: 3
	}
}