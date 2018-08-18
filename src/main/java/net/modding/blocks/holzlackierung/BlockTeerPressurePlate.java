package net.modding.blocks.holzlackierung;

import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.modding.main.modding;
import net.modding.registry.Holzlackierung;
import net.modding.util.UnluckEffekte;

public class BlockTeerPressurePlate extends BlockPressurePlate{

	private Holzlackierung registry = modding.registry.holz;
	
	public BlockTeerPressurePlate() {
		super(Material.WOOD, BlockPressurePlate.Sensitivity.EVERYTHING);
		setRegistryName("teer_pressure_plate");
		setUnlocalizedName("teer_pressure_plate");
		setCreativeTab(registry.teerTab);
		setHarvestLevel("axe", 0);
		setHardness(0.65f);
		setSoundType(SoundType.WOOD);
		setResistance(0.24f);
	}

	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		super.onBlockHarvested(worldIn, pos, state, player);
		UnluckEffekte.teereAxt(player, worldIn, pos, this, state, registry);
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
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		UnluckEffekte.unluckBlock(this, worldIn, playerIn, pos);
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
	}
	
}
