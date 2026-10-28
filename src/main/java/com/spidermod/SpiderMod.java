package com.spidermod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class SpiderMod implements ModInitializer {
	public static final String MOD_ID = "spidermod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	/** Ag atici kullanan oyuncunun dusme hasarindan korundugu son oyun zamani (tick). */
	public static final Map<UUID, Long> SWING_UNTIL = new ConcurrentHashMap<>();

	@Override
	public void onInitialize() {
		ModArmorMaterials.init();
		ModItems.init();

		// Ag atici ile sallanirken ve hemen sonrasinda dusme hasari alma
		ServerLivingEntityEvents.ALLOW_DAMAGE.register((entity, source, amount) -> {
			if (entity instanceof ServerPlayerEntity player && source.isOf(DamageTypes.FALL)) {
				Long until = SWING_UNTIL.get(player.getUuid());
				if (until != null && player.getWorld().getTime() <= until) {
					return false;
				}
			}
			return true;
		});

		LOGGER.info("Spider-Man Mod yuklendi!");
	}
}
