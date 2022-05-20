package me.tzmo.noblockbreakparticles.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ParticleManager.class)
public class MixinDisableBlockBreakParticles {
	@Inject(method = "addBlockBreakParticles", at = @At("HEAD"), cancellable = true)
	public void addBlockBreakParticles(BlockPos pos, BlockState state, CallbackInfo ci)
	{
		ci.cancel();
	}

	@Inject(method = "addBlockBreakingParticles", at = @At("HEAD"), cancellable = true)
	public void addBlockBreakParticles(BlockPos pos, Direction direction, CallbackInfo ci)
	{
		ci.cancel();
	}
}
