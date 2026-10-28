package com.spidermod;

import net.minecraft.block.Block;
import net.minecraft.item.Items;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;

/** Cok guclu (OP) alet malzemesi. */
public enum OpToolMaterial implements ToolMaterial {
	INSTANCE;

	@Override
	public int getDurability() {
		return 4000;
	}

	@Override
	public float getMiningSpeedMultiplier() {
		return 30.0f;
	}

	@Override
	public float getAttackDamage() {
		return 22.0f;
	}

	@Override
	public TagKey<Block> getInverseTag() {
		return BlockTags.INCORRECT_FOR_NETHERITE_TOOL;
	}

	@Override
	public int getEnchantability() {
		return 30;
	}

	@Override
	public Ingredient getRepairIngredient() {
		return Ingredient.ofItems(Items.NETHERITE_INGOT);
	}
}
