package net.modding.blocks.holzlackierung;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.modding.main.modding;
import net.modding.registry.Holzlackierung;
import net.modding.util.UnluckEffekte;

public class BlockTeerFenceGate extends BlockFenceGate {

	private String name = "teer_fence_gate";
	private Holzlackierung registry = modding.registry.holz;
	private static Block[] fenceGateArray = new Block[6];
	private double abstand;
	
	public BlockTeerFenceGate() {
		super(EnumType.OAK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(registry.teerTab);
		setHarvestLevel("axe", 1);
		setHardness(2.3F);
		setSoundType(SoundType.WOOD);
		setResistance(5.5F);
		abstand = 0.278D;
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		super.onEntityWalk(worldIn, pos, entityIn);
		if (entityIn instanceof EntityLivingBase) {
			AxisAlignedBB zaunBox = getBoundingBox(worldIn.getBlockState(pos), worldIn, pos);
			AxisAlignedBB entityBox = ((EntityLivingBase)entityIn).getEntityBoundingBox(); //TODO: BoundingBoxes richtig überprüfen
		if (!isPassable(worldIn, pos) && (pos.getX() + zaunBox.maxX) != entityBox.minX && (pos.getZ() + zaunBox.maxZ) != entityBox.minZ && (pos.getY() + zaunBox.maxY) != entityBox.minY
				|| (pos.getX() + zaunBox.maxX) != entityBox.maxX && (pos.getZ() + zaunBox.maxZ) != entityBox.maxZ && (pos.getY() + zaunBox.maxY) != entityBox.maxY) {
		UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
			}
		}
	}
	
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		super.onEntityCollidedWithBlock(worldIn, pos, state, entityIn);
		if (entityIn instanceof EntityLivingBase) {
			AxisAlignedBB zaunBox = getBoundingBox(state, worldIn, pos);
			AxisAlignedBB blockBox = zaunBox;
			AxisAlignedBB entityBox = ((EntityLivingBase)entityIn).getEntityBoundingBox(); //TODO: BoundingBoxes richtig überprüfen
			
			double xPos = pos.getX(); double xMaxBlock = blockBox.maxX; double xMax = xMaxBlock + xPos;
			double zPos = pos.getZ(); double zMaxBlock = blockBox.maxZ; double zMax = zMaxBlock + zPos;
			
		if (!isPassable(worldIn, pos) && state.getValue(FACING) == EnumFacing.EAST || state.getValue(FACING) == EnumFacing.WEST) { // x-Richtung
			double aktueller_max_abstandX = xMax - entityBox.maxX;
			if (aktueller_max_abstandX >= 0 && aktueller_max_abstandX <= abstand) {
				modding.sayStaticln(Double.toString(aktueller_max_abstandX));
				UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
				}
			} else if (!isPassable(worldIn, pos) && state.getValue(FACING) == EnumFacing.NORTH || state.getValue(FACING) == EnumFacing.SOUTH) { //z-Richtung
				double aktueller_max_abstandZ = zMax - entityBox.maxZ;
				if (aktueller_max_abstandZ >= 0 && aktueller_max_abstandZ <= abstand) {
					modding.sayStaticln(Double.toString(aktueller_max_abstandZ));
					UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
				}
			}
		}
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		UnluckEffekte.unluckBlock(this, worldIn, playerIn, pos);
		AxisAlignedBB zaunBox = getBoundingBox(state, worldIn, pos);
		double xPos = pos.getX(); double xMaxBlock = zaunBox.maxX; double xMax = xMaxBlock + xPos;
		double zPos = pos.getZ(); double zMaxBlock = zaunBox.maxZ; double zMax = zMaxBlock + zPos;
		double aktueller_max_abstandX = xMax - playerIn.getEntityBoundingBox().maxX;
		double aktueller_max_abstandZ = zMax - playerIn.getEntityBoundingBox().maxZ;
		modding.sayStaticln(playerIn.getEntityBoundingBox() + " ist die CollisionBox der Entity und " + Double.toString(zaunBox.maxX + pos.getX()) + " die des Zauns in x, " + Double.toString(zaunBox.maxZ + pos.getZ()) + " in z und " + Double.toString(zaunBox.maxY + pos.getY()) + " in Y Richtung.");
		modding.sayStaticln(Double.toString(aktueller_max_abstandX) + " ist der Abstand in x und " + Double.toString(aktueller_max_abstandZ) + " der Abstand in Z Richtung. Das Zauntor");
		return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
	}
	
	public static void fulleFenceGateArray () {
		fenceGateArray[0] = Blocks.OAK_FENCE_GATE;
		fenceGateArray[1] = Blocks.ACACIA_FENCE_GATE;
		fenceGateArray[2] = Blocks.SPRUCE_FENCE_GATE;
		fenceGateArray[3] = Blocks.BIRCH_FENCE_GATE;
		fenceGateArray[4] = Blocks.JUNGLE_FENCE_GATE;
		fenceGateArray[5] = Blocks.DARK_OAK_FENCE_GATE;
	}
	
	public static Block[] getFenceGateArray() {
		return fenceGateArray;
	}
	
}
