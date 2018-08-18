package net.modding.blocks.holzlackierung;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.modding.main.modding;
import net.modding.registry.Holzlackierung;
import net.modding.util.UnluckEffekte;

public class BlockTeerTreppe extends BlockStairs {

	private String name = "teer_treppe";
	private Holzlackierung registry = modding.registry.holz;
	private static Block[] treppenArray = new Block[6];
	
	public BlockTeerTreppe(IBlockState modelState) {
		super(modelState);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.teerTab);
		setHarvestLevel("axe", 1);
		setHardness(2.3F);
		setSoundType(SoundType.WOOD);
		setResistance(5.5F);
		useNeighborBrightness = true;
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
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add(UnluckEffekte.teerText);
		tooltip.add(I18n.translateToLocal(TextFormatting.AQUA + "" + TextFormatting.ITALIC + "text.Teertreppe.text"));
	}

	public static void fulleTreppenArray () {
		treppenArray[0] = Blocks.OAK_STAIRS;
		treppenArray[1] = Blocks.ACACIA_STAIRS;
		treppenArray[2] = Blocks.SPRUCE_STAIRS;
		treppenArray[3] = Blocks.BIRCH_STAIRS;
		treppenArray[4] = Blocks.JUNGLE_STAIRS;
		treppenArray[5] = Blocks.DARK_OAK_STAIRS;
	}
	
	public static Block[] getTreppenArray() {
		return treppenArray;
	}
}
