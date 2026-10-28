package com.spidermod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.Vec3d;

/**
 * Ag atici ile sallanma:
 *  - Ag atici elindeyken SAG TIK'a basili tut: baktigin bloga ag atilir ve seni ceker.
 *  - ZIPLA tusu: ipi kisaltir (yukari cek).
 *  - ILERI tusu: bakis yonune ekstra hiz verir.
 *  - Sag tiki birak: ag kopar, hizinla ucarsin.
 */
public class SpiderModClient implements ClientModInitializer {
	private static final double MAX_RANGE = 45.0;
	private static final double MIN_ROPE = 3.0;
	private static final double MAX_SPEED = 2.4;

	private static Vec3d anchor = null;
	private static double ropeLength = 0;

	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(SpiderModClient::tick);
	}

	private static void tick(MinecraftClient client) {
		ClientPlayerEntity player = client.player;
		if (player == null || client.world == null) {
			anchor = null;
			return;
		}

		boolean holding = player.getMainHandStack().isOf(ModItems.WEB_SHOOTER)
				|| player.getOffHandStack().isOf(ModItems.WEB_SHOOTER);
		boolean pressed = client.options.useKey.isPressed() && client.currentScreen == null;

		if (!holding || !pressed) {
			anchor = null;
			return;
		}

		// Ag henuz atilmadiysa: baktigin yere nisan al
		if (anchor == null) {
			HitResult hit = player.raycast(MAX_RANGE, 1.0f, false);
			if (hit.getType() != HitResult.Type.BLOCK) {
				return;
			}
			anchor = hit.getPos();
			double dist = anchor.distanceTo(player.getEyePos());
			ropeLength = Math.max(MIN_ROPE, dist * 0.8);
			player.playSound(SoundEvents.ENTITY_FISHING_BOBBER_THROW, 1.0f, 1.3f);
		}

		Vec3d body = player.getPos().add(0, player.getHeight() * 0.6, 0);
		Vec3d toAnchor = anchor.subtract(body);
		double dist = toAnchor.length();
		if (dist < 0.8) {
			anchor = null;
			return;
		}
		Vec3d dir = toAnchor.multiply(1.0 / dist);

		Vec3d vel = player.getVelocity();

		if (client.options.jumpKey.isPressed()) {
			ropeLength = Math.max(MIN_ROPE, ropeLength - 0.35);
		}

		// Ip gerildiyse: ipten uzaklasma hizini sil, anchor'a dogru cek
		if (dist > ropeLength) {
			double outward = -vel.dotProduct(dir);
			if (outward > 0) {
				vel = vel.add(dir.multiply(outward));
			}
			vel = vel.add(dir.multiply(Math.min((dist - ropeLength) * 0.15, 0.6)));
		}

		if (client.options.forwardKey.isPressed()) {
			vel = vel.add(player.getRotationVector().multiply(0.035));
		}

		double speed = vel.length();
		if (speed > MAX_SPEED) {
			vel = vel.multiply(MAX_SPEED / speed);
		}

		player.setVelocity(vel);
		player.fallDistance = 0;

		// Ag cizgisi (parcacik)
		Vec3d from = player.getPos().add(0, player.getHeight() * 0.7, 0);
		Vec3d line = anchor.subtract(from);
		int steps = (int) Math.min(30, Math.max(4, line.length() * 1.5));
		for (int i = 0; i <= steps; i++) {
			Vec3d p = from.add(line.multiply(i / (double) steps));
			client.world.addParticle(ParticleTypes.CRIT, p.x, p.y, p.z, 0, 0, 0);
		}
	}
}
