package net.mcreator.minepiecegoatededition.client.particle;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.particles.BasicParticleType;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.client.particle.SpriteTexturedParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.IParticleRenderType;
import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IAnimatedSprite;

@OnlyIn(Dist.CLIENT)
public class SparkParticleParticle extends SpriteTexturedParticle {
	public static SparkParticleIParticleFactory factory(IAnimatedSprite spriteSet) {
		return new SparkParticleIParticleFactory(spriteSet);
	}

	@OnlyIn(Dist.CLIENT)
	public static class SparkParticleIParticleFactory implements IParticleFactory<BasicParticleType> {
		private final IAnimatedSprite spriteSet;

		public SparkParticleIParticleFactory(IAnimatedSprite spriteSet) {
			this.spriteSet = spriteSet;
		}

		public Particle makeParticle(BasicParticleType typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			return new SparkParticleParticle(worldIn, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
		}
	}

	private final IAnimatedSprite spriteSet;

	protected SparkParticleParticle(ClientWorld world, double x, double y, double z, double vx, double vy, double vz, IAnimatedSprite spriteSet) {
		super(world, x, y, z);
		this.spriteSet = spriteSet;
		this.setSize(0.2f, 0.2f);
		this.particleScale *= 2f;
		this.maxAge = (int) Math.max(1, 13 + (this.rand.nextInt(4) - 2));
		this.particleGravity = 0f;
		this.canCollide = true;
		this.motionX = vx * 1;
		this.motionY = vy * 1;
		this.motionZ = vz * 1;
		this.selectSpriteWithAge(spriteSet);
	}

	@Override
	public int getBrightnessForRender(float partialTick) {
		return 15728880;
	}

	@Override
	public IParticleRenderType getRenderType() {
		return IParticleRenderType.PARTICLE_SHEET_LIT;
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.isExpired) {
			this.setSprite(this.spriteSet.get((this.age / 1) % 14 + 1, 14));
		}
	}
}
