package net.modding.blocks.holzlackierung.metadata;

import java.util.List;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.modding.blocks.holzlackierung.BasicBlockTeer;
import net.modding.main.modding;
import net.modding.util.UnluckEffekte;

public class BlockTeerPlank extends BasicBlockTeer implements IMetaBlockName{
	
	public static final PropertyEnum<TeerTypes> type = PropertyEnum.<TeerTypes>create("teertypes", TeerTypes.class);
	
	public BlockTeerPlank() {
		super("plank_teer", "teer_plank", Material.WOOD, 1, 3.5F, 6F, SoundType.WOOD);
		setDefaultState(this.blockState.getBaseState().withProperty(type, TeerTypes.oak));
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] {type});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (meta == 0) 
			return this.getDefaultState().withProperty(type, TeerTypes.oak);
		
		if (meta == 1) 
			return this.getDefaultState().withProperty(type, TeerTypes.spruce);
		
		if (meta == 2) 
			return this.getDefaultState().withProperty(type, TeerTypes.birke);
		
		if (meta == 3) 
			return this.getDefaultState().withProperty(type, TeerTypes.jungle);
		
		if (meta == 4) 
			return this.getDefaultState().withProperty(type, TeerTypes.steppe);
		
		if (meta == 5) 
			return this.getDefaultState().withProperty(type, TeerTypes.dark_oak);
		return this.getDefaultState().withProperty(type, TeerTypes.oak);
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		TeerTypes Type = (TeerTypes)state.getValue(type);
		return Type.getMetadata();
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		list.add(new ItemStack(itemIn, 1, 0));
		list.add(new ItemStack(itemIn, 1, 1));
		list.add(new ItemStack(itemIn, 1, 2));
		list.add(new ItemStack(itemIn, 1, 3));
		list.add(new ItemStack(itemIn, 1, 4));
		list.add(new ItemStack(itemIn, 1, 5));
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add(UnluckEffekte.teerText);
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
	
	public static void registerTeerPlanks () {
		ModelBakery.registerItemVariants(Item.getItemFromBlock(registry.holz.plank_teer), new ResourceLocation(modding.MODID, "oakplank_teer"), new ResourceLocation(modding.MODID, "spruceplank_teer"), 
			new ResourceLocation(modding.MODID, "jungleplank_teer"), new ResourceLocation(modding.MODID, "steppeplank_teer"), new ResourceLocation(modding.MODID, "birkeplank_teer"), new ResourceLocation(modding.MODID, "darkoakplank_teer"));
	}

	@Override
	public String getSpecialName(ItemStack stack) {
		if (stack.getItemDamage() == 0) 
			return "oakplank_teer";
		
		if (stack.getItemDamage() == 1) 
			return "spruceplank_teer";
		
		if (stack.getItemDamage() == 2) 
			return "birkeplank_teer";
		
		if (stack.getItemDamage() == 3) 
			return "jungleplank_teer";
		
		if (stack.getItemDamage() == 4) 
			return "steppeplank_teer";
		
		if (stack.getItemDamage() == 5) 
			return "darkoakplank_teer";
		return "oakplank_teer";
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
	
}
