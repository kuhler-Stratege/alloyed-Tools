package net.modding.blocks.holzlackierung;

import java.util.List;

import net.minecraft.block.BlockButtonWood;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.modding.main.modding;
import net.modding.registry.Holzlackierung;
import net.modding.util.UnluckEffekte;

public class BlockTeerKnopf extends BlockButtonWood{

	public static Holzlackierung registry = modding.registry.holz;
	
	public BlockTeerKnopf() {
		setUnlocalizedName("teer_knopf");
		setRegistryName("teer_knopf");
		setCreativeTab(registry.teerTab);
		setResistance(0.2F);
		setHardness(0.8F);
		setSoundType(SoundType.WOOD);
		setHarvestLevel("axe", 0);
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
		tooltip.add(I18n.translateToLocal(TextFormatting.AQUA + "" + TextFormatting.ITALIC + "text.Teerknopf.text"));
	}
	
	@Override
	public void onBlockHarvested(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
		super.onBlockHarvested(worldIn, pos, state, player);
		UnluckEffekte.teereAxt(player, worldIn, pos, this, state, registry);
	}
}
