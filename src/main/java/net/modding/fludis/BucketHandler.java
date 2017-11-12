package net.modding.fludis;
/*This BucketHandler class is the one from Buildcraft, all credits to Spacetoad and the BuildCraft team.
 */
import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.eventhandler.Event;

public class BucketHandler {
    public static BucketHandler INSTANCE = new BucketHandler();
    public Map<Block, Item> buckets = new HashMap<Block, Item>();
    
    private BucketHandler() {
    }
    
    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event) {

        ItemStack result = fillCustomBucket(event.getWorld(), event.getTarget());

        if (result == null)
            return;

        result = result;
        event.setResult(Event.Result.ALLOW);
    }

    private ItemStack fillCustomBucket(World world, RayTraceResult rayTraceResult) {

        Block block = world.getBlockState(new BlockPos (rayTraceResult.hitVec.xCoord, rayTraceResult.hitVec.yCoord, rayTraceResult.hitVec.zCoord)).getBlock();

        Item bucket = buckets.get(block);
        if (bucket != null && block.getMetaFromState(world.getBlockState(new BlockPos (rayTraceResult.hitVec.xCoord, rayTraceResult.hitVec.yCoord, rayTraceResult.hitVec.zCoord))) == 0) {
            world.setBlockToAir(new BlockPos (rayTraceResult.hitVec.xCoord, rayTraceResult.hitVec.yCoord, rayTraceResult.hitVec.zCoord));
            return new ItemStack(bucket);
        } else
            return null;

    }
}