package me.spartacus04.berrybush.mixins;

import net.minecraft.block.BushBlock;
import net.minecraft.block.SweetBerryBushBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

import static net.minecraft.block.SweetBerryBushBlock.AGE;

@Mixin(SweetBerryBushBlock.class)
public class SweetBerryBushMixin extends BushBlock {
    public SweetBerryBushMixin(Properties properties) {
        super(properties);
    }

    @Inject(method = "randomTick", at = @At("HEAD"))
    public void overrideRandomTick(net.minecraft.block.BlockState state, net.minecraft.world.server.ServerWorld worldIn, net.minecraft.util.math.BlockPos pos, java.util.Random random, org.spongepowered.asm.mixin.injection.callback.CallbackInfo ci) {
        int i = state.get(AGE);
        if (i < 3 && net.minecraftforge.common.ForgeHooks.onCropsGrowPre(worldIn, pos, state,random.nextInt(5) == 0)) {
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
            net.minecraftforge.common.ForgeHooks.onCropsGrowPost(worldIn, pos, state);
        }
    }
}