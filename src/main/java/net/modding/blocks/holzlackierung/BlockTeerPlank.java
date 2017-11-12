package net.modding.blocks.holzlackierung;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.modding.fludis.holzlackierung.Teer;
import net.modding.util.UnluckEffekte;

public class BlockTeerPlank extends BasicBlockTeer{
	
	public BlockTeerPlank() {
		super("plank_teer", Material.WOOD, 1, 3.5F, SoundType.WOOD);
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add(TextFormatting.DARK_RED + I18n.translateToLocal("text.teer.text"));
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
	
	/* Hier soll dieser Block zu Brettern ersetzt werden, wenn daneben Wasser ist.
	public void ersetzen (World world, BlockPos pos, IBlockState state, Block vorher, Block nachher) {
		for(EnumFacing facing : EnumFacing.values()) {
			
			if (facing == EnumFacing.EAST || facing == EnumFacing.WEST) {
			Block block = world.getBlockState(pos.offset(facing)).getBlock();
			if (block == vorher) {
				world.setBlockState(pos.offset(facing), nachher.getDefaultState());
				}
			}
		}
	}
	@Override
	public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
		super.onBlockAdded(world, pos, state);
		ersetzen(world, pos, state, Blocks.WATER, Blocks.PLANKS);
	}
	@Override
	public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock) {
		super.neighborChanged(state, world, pos, neighborBlock);
		ersetzen(world, pos, state, Blocks.WATER, Blocks.PLANKS);
	}*/
	
}
