package com.fuzs.aquaacrobatics.item;

import com.fuzs.aquaacrobatics.block.coral.BlockAbstractCoral;
import com.fuzs.aquaacrobatics.block.coral.BlockCoral;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockCoral extends ItemBlock {
    public ItemBlockCoral(BlockAbstractCoral block) {
        super(block);
    }

    @Override
    public String getTranslationKey(ItemStack stack) {
        IBlockState state = block.getStateFromMeta(stack.getItemDamage());
        BlockAbstractCoral coral = (BlockAbstractCoral)block;
        StringBuilder sb = new StringBuilder();
        sb.append("tile.aquaacrobatics.");
        if(coral.isDead(state))
            sb.append("dead_");
        sb.append(coral.getCoralType(state).getName()).append("_").append(block.getRegistryName().getPath());
        return sb.toString();
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}
