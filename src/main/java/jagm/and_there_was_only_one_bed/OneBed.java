package jagm.and_there_was_only_one_bed;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent.RightClickBlock;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod("and_there_was_only_one_bed")
public class OneBed {

	public OneBed() {
		MinecraftForge.EVENT_BUS.register(this);
		MinecraftForge.EVENT_BUS.register(OneBed.class);
	}

	@SubscribeEvent
	public void onRightClickBlock(RightClickBlock event) {
		Level level = event.getEntity().level();
		BlockPos pos = event.getHitVec().getBlockPos();
		BlockState blockState = level.getBlockState(pos);
		if (blockState.getBlock() instanceof BedBlock) {
			if (blockState.getValue(BedBlock.OCCUPIED)) {
				level.setBlock(pos, blockState.setValue(BedBlock.OCCUPIED, false), 3);
			}
		}
	}

}
