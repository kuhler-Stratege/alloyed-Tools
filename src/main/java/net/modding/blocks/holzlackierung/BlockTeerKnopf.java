package net.modding.blocks.holzlackierung;

import net.minecraft.block.BlockButtonWood;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.modding.util.UnluckEffekte;

public class BlockTeerKnopf extends BlockButtonWood{

	public static Benennung_Registry registry = modding.registry;
	
	public BlockTeerKnopf() {
		setUnlocalizedName("teer_knopf");
		setCreativeTab(registry.teerTab);
		setResistance(0.2F);
		setHardness(0.8F);
		setStepSound(soundTypeWood);
		setHarvestLevel("axe", 1);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn) {
		UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
	}
}
