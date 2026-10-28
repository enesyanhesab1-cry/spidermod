package com.spidermod;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

/**
 * Ag atici. Asil sallanma hareketi istemci tarafinda (SpiderModClient) yapilir;
 * burada sadece kol sallama ve dusme hasari korumasi ayarlanir.
 */
public class WebShooterItem extends Item {
	public WebShooterItem(Settings settings) {
		super(settings);
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (!world.isClient) {
			// Sallanirken ve sonraki 4 saniye dusme hasari yok
			SpiderMod.SWING_UNTIL.put(user.getUuid(), world.getTime() + 80);
			user.fallDistance = 0;
		}
		return TypedActionResult.success(user.getStackInHand(hand));
	}
}
