package net.modding.fluids.holzlackierung;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.statemap.StateMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.common.property.ExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.modding.blocks.holzlackierung.BlockTeerFenceGate;
import net.modding.blocks.holzlackierung.BlockTeerTreppe;
import net.modding.blocks.holzlackierung.BlockTeerZaun;
import net.modding.blocks.holzlackierung.metadata.BlockTeerPlank;
import net.modding.main.modding;
import net.modding.registry.Holzlackierung;
import net.modding.util.UnluckEffekte;

public class BlockFluidTeer extends BlockFluidClassic {
		
		public static final String name = "teer";
		public static Holzlackierung registry = modding.registry.holz;
		
		public BlockFluidTeer(Fluid fluid) {
			super(fluid, registry.materialFluidTeer);
			setUnlocalizedName("blockFluid_" + name);
			setRegistryName(modding.MODID, "fluidBlock_" + name);
			setRenderLayer(BlockRenderLayer.TRANSLUCENT);
			setDefaultState(blockState.getBaseState().withProperty(LEVEL, 0));
		}
		
		@Override
		public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
			if (entityIn instanceof EntityLivingBase || entityIn instanceof EntityItem) {
				UnluckEffekte.unluckBlock(this, worldIn, entityIn, pos);
				entityIn.setFire(7);
			}
		}
		
		public void ersetzen(World world, BlockPos pos, Block vorher, Block nachher) {
			if (world != null && pos != null && vorher != null) {
				int meta = new Random().nextInt();
				for(EnumFacing facing : EnumFacing.values()) {
					BlockPos offsetPos = pos.offset(facing);
					IBlockState offsetState = world.getBlockState(offsetPos);
					Block block = world.getBlockState(pos.offset(facing)).getBlock();
					if (nachher != null) {
						try {
						if (block.getBlockState().getBlock() == vorher.getBlockState().getBlock()) {
						meta = vorher.getMetaFromState(offsetState);
						world.setBlockState(offsetPos, nachher.getStateFromMeta(meta));
						} 
					} catch (IllegalArgumentException e) {
						e.printStackTrace();
					}
				} else  if (block.getBlockState().getBlock() == vorher.getBlockState().getBlock()){
					try {
						world.setBlockState(offsetPos, Blocks.AIR.getDefaultState());
						} catch (IllegalArgumentException e) {
							e.printStackTrace();
						}
					}
				}
				
			} else {
				throw new NullPointerException("Der Wert eines Parameters ist null. Nur Parameter nachher darf null sein.");
			}
		}
		
		@Override
		public void onBlockAdded(World world, BlockPos pos, IBlockState state) {
			super.onBlockAdded(world, pos, state);
			addEffekts(world, pos, state);
		}
		
		@Override
		public void neighborChanged(IBlockState state, World world, BlockPos pos, Block neighborBlock) {
			super.neighborChanged(state, world, pos, neighborBlock);
			addEffekts(world, pos, state);
		}
		
		@Override
		protected BlockStateContainer createBlockState() {
			super.createBlockState();
			return new ExtendedBlockState(this, new IProperty[] { LEVEL, BlockTeerPlank.type, BlockPlanks.VARIANT }, FLUID_RENDER_PROPS.toArray(new IUnlistedProperty<?>[0]));
		}
		
		@Override
		public EnumBlockRenderType getRenderType(IBlockState state) {
			return EnumBlockRenderType.MODEL;
		}
		
		public void preInit() {

			GameRegistry.register(this);
			ItemBlock itemBlock = new ItemBlock(this);
			itemBlock.setRegistryName(this.getRegistryName());
			GameRegistry.register(itemBlock);
		}
		
		@SubscribeEvent
		@SideOnly(Side.CLIENT)
		public static void onModelBake (ModelBakeEvent event) {
			  event.getModelManager().getBlockModelShapes().registerBlockWithStateMapper(registry.holz.blockFluidTeer, new StateMap.Builder().ignore(BlockFluidBase.LEVEL).build());
		}
		
		public void addEffekts(World world, BlockPos pos, IBlockState state) {
			ersetzen(world, pos, Blocks.PLANKS, modding.registry.holz.plank_teer);
			ersetzen(world, pos, Blocks.WOODEN_SLAB, modding.registry.holz.teerHalfSlab);
			ersetzen(world, pos, Blocks.DOUBLE_WOODEN_SLAB, modding.registry.holz.teerDoubleSlab);
			ersetzen(world, pos, Blocks.FLOWING_WATER, Blocks.COAL_BLOCK);
			ersetzen(world, pos, Blocks.WATER, Blocks.COAL_BLOCK);
			ersetzen(world, pos, Blocks.LAVA, Blocks.LAVA);
			ersetzen(world, pos, Blocks.FLOWING_LAVA, Blocks.FLOWING_LAVA);
			ersetzen(world, pos, Blocks.WOODEN_BUTTON, registry.teer_knopf);
			ersetzen(world, pos, Blocks.WOODEN_PRESSURE_PLATE, registry.teer_pressure_plate);
			
			if (BlockTeerZaun.getZaunArray().length > 0 && BlockTeerFenceGate.getFenceGateArray().length > 0 && BlockTeerTreppe.getTreppenArray().length > 0) {
				try {
					for (int i=0; i<BlockTeerZaun.getZaunArray().length; i++) {
						ersetzen(world, pos, BlockTeerZaun.getZaunArray()[i], registry.holz.teer_zaun);
					}
					for (int i=0; i<BlockTeerFenceGate.getFenceGateArray().length; i++) {
						ersetzen(world, pos, BlockTeerFenceGate.getFenceGateArray()[i], registry.holz.teer_fence_gate);
					}
					for (int i=0; i<BlockTeerTreppe.getTreppenArray().length; i++) {
						ersetzen(world, pos, BlockTeerTreppe.getTreppenArray()[i], registry.holz.teer_treppe);}
					}
			catch (NullPointerException e) {
				e.printStackTrace();
				}
			}
		}
}


