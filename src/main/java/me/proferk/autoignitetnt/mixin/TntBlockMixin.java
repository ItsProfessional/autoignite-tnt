package me.proferk.autoignitetnt.mixin;

import net.minecraft.block.TntBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(TntBlock.class)
public abstract class TntBlockMixin {
    @Redirect(method = "onBlockAdded", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;isReceivingRedstonePower(Lnet/minecraft/util/math/BlockPos;)Z"))
    private boolean autoignite(World instance, BlockPos blockPos)
    {
        return true;
    }
}
