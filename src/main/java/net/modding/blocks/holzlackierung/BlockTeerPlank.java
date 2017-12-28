package net.modding.blocks.holzlackierung;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.modding.util.UnluckEffekte;

public class BlockTeerPlank extends BasicBlockTeer{
	
	public BlockTeerPlank() {
		super("plank_teer", Material.wood, 1, 3.5F, soundTypeWood);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn) {
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
