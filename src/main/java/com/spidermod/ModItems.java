package com.spidermod;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public final class ModItems {
	private ModItems() {
	}

	// --- Ag atici ---
	public static final Item WEB_SHOOTER = register("web_shooter",
			new WebShooterItem(new Item.Settings().maxCount(1).rarity(Rarity.RARE)));

	// --- OP esyalar ---
	public static final Item OP_SWORD = register("op_sword",
			new SwordItem(OpToolMaterial.INSTANCE, new Item.Settings()
					.rarity(Rarity.EPIC)
					.fireproof()
					.attributeModifiers(SwordItem.createAttributeModifiers(OpToolMaterial.INSTANCE, 10, -2.0f))));

	public static final Item OP_PICKAXE = register("op_pickaxe",
			new PickaxeItem(OpToolMaterial.INSTANCE, new Item.Settings()
					.rarity(Rarity.EPIC)
					.fireproof()
					.attributeModifiers(PickaxeItem.createAttributeModifiers(OpToolMaterial.INSTANCE, 1.0f, -2.6f))));

	public static final Item OP_AXE = register("op_axe",
			new AxeItem(OpToolMaterial.INSTANCE, new Item.Settings()
					.rarity(Rarity.EPIC)
					.fireproof()
					.attributeModifiers(AxeItem.createAttributeModifiers(OpToolMaterial.INSTANCE, 5.0f, -2.8f))));

	// --- Spider-Man kostumu ---
	public static final Item SPIDER_HELMET = register("spider_helmet",
			new ArmorItem(ModArmorMaterials.SPIDER_SUIT, ArmorItem.Type.HELMET,
					new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));

	public static final Item SPIDER_CHESTPLATE = register("spider_chestplate",
			new ArmorItem(ModArmorMaterials.SPIDER_SUIT, ArmorItem.Type.CHESTPLATE,
					new Item.Settings().maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));

	public static final Item SPIDER_LEGGINGS = register("spider_leggings",
			new ArmorItem(ModArmorMaterials.SPIDER_SUIT, ArmorItem.Type.LEGGINGS,
					new Item.Settings().maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));

	public static final Item SPIDER_BOOTS = register("spider_boots",
			new ArmorItem(ModArmorMaterials.SPIDER_SUIT, ArmorItem.Type.BOOTS,
					new Item.Settings().maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));

	// --- Creative sekmesi ---
	public static final ItemGroup SPIDER_GROUP = Registry.register(
			Registries.ITEM_GROUP,
			Identifier.of(SpiderMod.MOD_ID, "main"),
			FabricItemGroup.builder()
					.icon(() -> new ItemStack(WEB_SHOOTER))
					.displayName(Text.translatable("itemGroup.spidermod.main"))
					.entries((context, entries) -> {
						entries.add(WEB_SHOOTER);
						entries.add(SPIDER_HELMET);
						entries.add(SPIDER_CHESTPLATE);
						entries.add(SPIDER_LEGGINGS);
						entries.add(SPIDER_BOOTS);
						entries.add(OP_SWORD);
						entries.add(OP_PICKAXE);
						entries.add(OP_AXE);
					})
					.build()
	);

	private static Item register(String name, Item item) {
		return Registry.register(Registries.ITEM, Identifier.of(SpiderMod.MOD_ID, name), item);
	}

	public static void init() {
		// Sinifin yuklenmesini tetikler
	}
}
