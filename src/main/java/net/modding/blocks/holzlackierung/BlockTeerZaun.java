package net.modding.blocks.holzlackierung;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.modding.main.modding;
import net.modding.registry.Holzlackierung;
import net.modding.util.UnluckEffekte;

public class BlockTeerZaun extends BlockFence{

	public static Holzlackierung registry = modding.registry.holz;
	private String name = "teer_zaun";
	private static Block[] zaunArray = new Block [6];
	
	public BlockTeerZaun() {
		super(Material.WOOD, MapColor.OBSIDIAN);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.teerTab);
		setHarvestLevel("axe", 1);
		setHardness(2.3F);
		setSoundType(SoundType.WOOD);
		setResistance(5.5F);
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		super.onEntityWalk(worldIn, pos, entityIn);
		UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
		if (entityIn instanceof EntityLivingBase) {
		AxisAlignedBB zaunBox = getBoundingBox(state, worldIn, pos);
		double xPos = pos.getX(); double xMaxBlock = zaunBox.maxX; double xMax = xMaxBlock + xPos;
		double zPos = pos.getZ(); double zMaxBlock = zaunBox.maxZ; double zMax = zMaxBlock + zPos;
		double aktueller_max_abstandX = xMax - entityIn.getEntityBoundingBox().maxX;
		double aktueller_max_abstandZ = zMax - entityIn.getEntityBoundingBox().maxZ;
		EnumFacing facing = null;
		EnumFacing entityFacing = entityIn.getHorizontalFacing();
		boolean keins = false;
			if (state.getValue(NORTH).booleanValue() && !state.getValue(SOUTH).booleanValue() && !state.getValue(EAST).booleanValue() && !state.getValue(WEST).booleanValue()) {
				facing = EnumFacing.NORTH;
			}
			else if (!state.getValue(NORTH).booleanValue() && state.getValue(SOUTH).booleanValue() && !state.getValue(EAST).booleanValue() && !state.getValue(WEST).booleanValue()) {
				facing = EnumFacing.SOUTH;
			}
			else if (!state.getValue(NORTH).booleanValue() && !state.getValue(SOUTH).booleanValue() && state.getValue(EAST).booleanValue() && !state.getValue(WEST).booleanValue()) {
				facing = EnumFacing.EAST;
			}
			else if (!state.getValue(NORTH).booleanValue() && !state.getValue(SOUTH).booleanValue() && !state.getValue(EAST).booleanValue() && state.getValue(WEST).booleanValue()) {
				facing = EnumFacing.WEST;
			}
			else if (!state.getValue(NORTH).booleanValue() && !state.getValue(SOUTH).booleanValue() && !state.getValue(EAST).booleanValue() && state.getValue(WEST).booleanValue()) {
				keins = true;
			}
			modding.sayStaticln(entityFacing.toString());
			if (facing != null) {
				if (entityFacing == facing) {
					if (aktueller_max_abstandZ >= 0 && aktueller_max_abstandZ <= 0.67) {
						UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
					}
				} else if (entityFacing == facing.rotateY()) {
					modding.sayStaticln(entityFacing.toString());
					if (aktueller_max_abstandX >= 0 && aktueller_max_abstandX <= 0.283) {
							UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
					}
				} else if (entityFacing == facing.rotateY().rotateY()) {
					if (aktueller_max_abstandX >= -0.63 && aktueller_max_abstandX <= 0) {
							UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
					}
				} else if (entityFacing == facing.rotateY().rotateY().rotateY()) {
					if (aktueller_max_abstandX >= -0.7 && aktueller_max_abstandX <= 0) {
							UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
					}
				}
			} else if (keins) {
				if (entityFacing == EnumFacing.NORTH) {
						if (aktueller_max_abstandZ >= -0.67 && aktueller_max_abstandZ <= 0) {
							UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
					}
				}
				else if (entityFacing == EnumFacing.EAST) {
					if (aktueller_max_abstandX >= 0 && aktueller_max_abstandX <= 0.4) {
							UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
					}
				}
				else if (entityFacing == EnumFacing.SOUTH) {
						if (aktueller_max_abstandZ >= 0 && aktueller_max_abstandZ <= 0.16) {
							UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
					}
				}
				else if (entityFacing == EnumFacing.WEST) {
					if (aktueller_max_abstandX >= -0.61 && aktueller_max_abstandX <= 0) {
							UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
					}
				}
			} else {
				if (aktueller_max_abstandX >= -0.7 && aktueller_max_abstandX <= 0) {
						UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
				}
			}
		}
	}
	
	public EnumFacing getConnectionFacing (IBlockState state, boolean keins) {
		if (state.getValue(NORTH).booleanValue() && !state.getValue(SOUTH).booleanValue() && !state.getValue(EAST).booleanValue() && !state.getValue(WEST).booleanValue()) {
			return EnumFacing.NORTH;
		}
		else if (!state.getValue(NORTH).booleanValue() && state.getValue(SOUTH).booleanValue() && !state.getValue(EAST).booleanValue() && !state.getValue(WEST).booleanValue()) {
			return EnumFacing.SOUTH;
		}
		else if (!state.getValue(NORTH).booleanValue() && !state.getValue(SOUTH).booleanValue() && state.getValue(EAST).booleanValue() && !state.getValue(WEST).booleanValue()) {
			return EnumFacing.EAST;
		}
		else if (!state.getValue(NORTH).booleanValue() && !state.getValue(SOUTH).booleanValue() && !state.getValue(EAST).booleanValue() && state.getValue(WEST).booleanValue()) {
			return EnumFacing.WEST;
		}
		else if (!state.getValue(NORTH).booleanValue() && !state.getValue(SOUTH).booleanValue() && !state.getValue(EAST).booleanValue() && state.getValue(WEST).booleanValue()) {
			keins = true;
			return null;
		}
		return null;
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add(UnluckEffekte.teerText);
		tooltip.add(I18n.translateToLocal(TextFormatting.AQUA + "" + TextFormatting.ITALIC + "text.Teerzaun.text"));
	}
	
	public static void fulleZaunArray() {
		zaunArray[0] = Blocks.OAK_FENCE;
		zaunArray[1] = Blocks.ACACIA_FENCE;
		zaunArray[2] = Blocks.SPRUCE_FENCE;
		zaunArray[3] = Blocks.BIRCH_FENCE;
		zaunArray[4] = Blocks.JUNGLE_FENCE;
		zaunArray[5] = Blocks.DARK_OAK_FENCE;
	}
	
	public static Block[] getZaunArray() {
		return zaunArray;
	}
}
