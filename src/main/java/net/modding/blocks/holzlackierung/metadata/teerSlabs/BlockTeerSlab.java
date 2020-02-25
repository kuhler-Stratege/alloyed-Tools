package net.modding.blocks.holzlackierung.metadata.teerSlabs;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.BlockSlab;
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
import net.minecraft.world.World;
import net.modding.blocks.holzlackierung.metadata.IMetaBlockName;
import net.modding.blocks.holzlackierung.metadata.TeerTypes;
import net.modding.main.modding;
import net.modding.registry.Benennung_Registry;
import net.modding.registry.Holzlackierung;
import net.modding.util.UnluckEffekte;

public abstract class BlockTeerSlab extends BlockSlab implements IMetaBlockName{

	public static final PropertyEnum<TeerTypes> Type = PropertyEnum.<TeerTypes>create("teerslabtype", TeerTypes.class);
	public static Benennung_Registry registry = modding.registry;
	private static Holzlackierung h = registry.holz;
	
	
	public BlockTeerSlab(String half) {
		super(Material.WOOD);
		IBlockState state = blockState.getBaseState();
		if (!isDouble()) {
			state = state.withProperty(HALF, EnumBlockHalf.BOTTOM);
			setCreativeTab(registry.teerTab);
		}
		setDefaultState(state.withProperty(Type, TeerTypes.oak));
		useNeighborBrightness = true;
		
		setUnlocalizedName("teer_" + half + "_slab");
		setRegistryName("teer_" + half + "_slab");
		setHardness(2.7F);
		setResistance(5.5F);
		setSoundType(SoundType.WOOD);
		setHarvestLevel("axe", 1);
	}
	
	@Override
	public String getUnlocalizedName(int meta) {
		return this.getUnlocalizedName();
	}
	
	@Override
	public IProperty<?> getVariantProperty() {
		return Type;
	}
	
	public Object getVariant(ItemStack stack) {
		return TeerTypes.values()[stack.getMetadata() & TeerTypes.values().length];
	}
	
	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		return TeerTypes.values()[stack.getMetadata() & TeerTypes.values().length];
	}
	
	@Override
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list) {
		if (itemIn != Item.getItemFromBlock(h.teerDoubleSlab)) {
			for (TeerTypes type : TeerTypes.values()) {
				list.add(new ItemStack(itemIn, 1, type.getMetadata()));
			}
		}
	}
		
	@Override
	public int damageDropped(IBlockState state) {
		return ((TeerTypes)state.getValue(Type)).getMetadata();
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
 
        if (meta == 0) 
            return this.getDefaultState().withProperty(Type, TeerTypes.oak);
        
        if (meta == 1) 
            return this.getDefaultState().withProperty(Type, TeerTypes.spruce);
        
        if (meta == 2) 
            return this.getDefaultState().withProperty(Type, TeerTypes.birke);
        
        if (meta == 3) 
            return this.getDefaultState().withProperty(Type, TeerTypes.jungle);
        
        if (meta == 4) 
            return this.getDefaultState().withProperty(Type, TeerTypes.steppe);
        
        if (meta == 5) 
            return this.getDefaultState().withProperty(Type, TeerTypes.dark_oak);
        return this.getDefaultState().withProperty(Type, TeerTypes.oak);
    }
	
	@Override
	public int getMetaFromState(IBlockState state) {
		int i = 0;
		i = i | ((TeerTypes)state.getValue(Type)).getMetadata();
		if (!this.isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP) 
			i |= 8;
			return i;
	}
	
	@Override
	@Nullable
	public Item getItemDropped(IBlockState state, Random rand, int fortune) {
		return Item.getItemFromBlock(h.teerHalfSlab);
	}
	
	@Override
	public ItemStack getItem(World worldIn, BlockPos pos, IBlockState state) {
		return new ItemStack(h.teerHalfSlab, 1, ((TeerTypes)state.getValue(Type)).getMetadata());
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return this.isDouble() ? new BlockStateContainer(this, new IProperty[] {Type}): new BlockStateContainer(this, new IProperty[] {HALF, Type});
	}
	
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List<String> tooltip, boolean advanced) {
		tooltip.add(UnluckEffekte.teerText);
	}
	
	public static void registerTeerSlabs () {
		ModelBakery.registerItemVariants(Item.getItemFromBlock(h.teerHalfSlab),
				new ResourceLocation(modding.MODID, "oakteer_half_slab"),
				new ResourceLocation(modding.MODID, "spruceteer_half_slab"),
				new ResourceLocation(modding.MODID, "jungleteer_half_slab"),
				new ResourceLocation(modding.MODID, "steppeteer_half_slab"),
				new ResourceLocation(modding.MODID, "birketeer_half_slab"),
				new ResourceLocation(modding.MODID, "darkoakteer_half_slab"),
				new ResourceLocation(modding.MODID, "oakteer_half_slab_top"),
				new ResourceLocation(modding.MODID, "spruceteer_half_slab_top"),
				new ResourceLocation(modding.MODID, "jungleteer_half_slab_top"),
				new ResourceLocation(modding.MODID, "steppeteer_half_slab_top"),
				new ResourceLocation(modding.MODID, "birketeer_half_slab_top"),
				new ResourceLocation(modding.MODID, "darkoakteer_half_slab_top"),
				new ResourceLocation(modding.MODID, "oakteer_half_slab_bottom"),
				new ResourceLocation(modding.MODID, "spruceteer_half_slab_bottom"),
				new ResourceLocation(modding.MODID, "jungleteer_half_slab_bottom"),
				new ResourceLocation(modding.MODID, "steppeteer_half_slab_bottom"),
				new ResourceLocation(modding.MODID, "birketeer_half_slab_bottom"),
				new ResourceLocation(modding.MODID, "darkoakteer_half_slab_bottom"));
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
	public String getSpecialName(ItemStack stack) {
		return TeerTypes.values()[stack.getItemDamage()].getName();
	}
}
