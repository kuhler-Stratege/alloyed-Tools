package net.modding.blocks.eisenlegierung;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class BasicBlockEisen extends Block{

	public static Benennung_Registry registry = new Benennung_Registry();
	
	public BasicBlockEisen(String name, Material material, int level, float harte, SoundType sound) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.chromTab);
		setHarvestLevel("pickaxe", level);
		setHardness(harte);
		setStepSound(sound);
		//Holz, Gold: 0, Stein: 1, Eisen: 2, Diamant: 3
	}
}
