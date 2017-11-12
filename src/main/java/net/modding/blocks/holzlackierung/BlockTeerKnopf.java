package net.modding.blocks.holzlackierung;

import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.modding.main.Benennung_Registry;
import net.modding.main.modding;
import net.modding.util.UnluckEffekte;

public class BlockTeerKnopf extends BlockButtonWood{

	public static Benennung_Registry registry = modding.registry;
	
	public BlockTeerKnopf() {
		setUnlocalizedName("teer_knopf");
		setRegistryName("teer_knopf");
		setCreativeTab(registry.teerTab);
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		super.onEntityWalk(worldIn, pos, entityIn);
		UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
		UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
	}
}
