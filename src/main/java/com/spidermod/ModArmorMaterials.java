package com.spidermod;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class ModArmorMaterials {
	private ModArmorMaterials() {
	}

	public static final RegistryEntry<ArmorMaterial> SPIDER_SUIT = registerSuit();

	private static RegistryEntry<ArmorMaterial> registerSuit() {
		Map<ArmorItem.Type, Integer> defense = new EnumMap<>(ArmorItem.Type.class);
		defense.put(ArmorItem.Type.BOOTS, 2);
		defense.put(ArmorItem.Type.LEGGINGS, 5);
		defense.put(ArmorItem.Type.CHESTPLATE, 6);
		defense.put(ArmorItem.Type.HELMET, 2);
		defense.put(ArmorItem.Type.BODY, 5);

		Identifier id = Identifier.of(SpiderMod.MOD_ID, "spider_suit");
		List<ArmorMaterial.Layer> layers = List.of(new ArmorMaterial.Layer(id));

		ArmorMaterial material = new ArmorMaterial(
				defense,
				15,
				SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,
				() -> Ingredient.ofItems(Items.RED_WOOL),
				layers,
				0.0f,
				0.0f
		);

		return Registry.registerReference(Registries.ARMOR_MATERIAL, id, material);
	}

	public static void init() {
		// Sinifin yuklenmesini tetikler
	}
}
