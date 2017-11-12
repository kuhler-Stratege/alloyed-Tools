package net.modding.blocks.holzlackierung;

import net.minecraft.block.BlockButtonWood;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;

public class BlockTeerKnopf extends BlockButtonWood{

	public static Benennung_Registry registry = modding.registry;
	
	public BlockTeerKnopf() {
		setUnlocalizedName("teer_knopf");
		setRegistryName("teer_knopf");
		setCreativeTab(registry.teerTab);
	}
	
}
