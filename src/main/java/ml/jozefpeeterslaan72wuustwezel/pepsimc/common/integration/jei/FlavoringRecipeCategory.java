package ml.jozefpeeterslaan72wuustwezel.pepsimc.common.integration.jei;



import java.util.ArrayList;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.IRecipeLayout;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.category.IRecipeCategory;
import ml.jozefpeeterslaan72wuustwezel.pepsimc.common.block.PepsiMcBlock;
import ml.jozefpeeterslaan72wuustwezel.pepsimc.common.data.recipes.FlavoringRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;

public class FlavoringRecipeCategory implements IRecipeCategory<FlavoringRecipe>{
	public static final ResourceLocation UID = new ResourceLocation("pepsimc","flavor");
	private final IDrawable bg;
	private final IDrawable icon;

	public FlavoringRecipeCategory(IGuiHelper helper) {
		this.bg = helper.createDrawable(new ResourceLocation("pepsimc","textures/gui/jei/flavor_machine_gui.png"), 0,0, 176, 85);
		this.icon = helper.createDrawableIngredient(new ItemStack(PepsiMcBlock.FLAVOR_MACHINE.get()));
	}
	
	@Override
	public ResourceLocation getUid() {
		// TODO Auto-generated method stub
		return UID;
	}

	@Override
	public Class<? extends FlavoringRecipe> getRecipeClass() {
		// TODO Auto-generated method stub
		return FlavoringRecipe.class;
	}

	@Override
	public IDrawable getBackground() {
		// TODO Auto-generated method stub
		return this.bg;
	}

	@Override
	public IDrawable getIcon() {
		// TODO Auto-generated method stub
		return this.icon;
	}

	@Override
	public void setIngredients(FlavoringRecipe recipe, IIngredients ingredients) {
		ArrayList<ItemStack> result = new ArrayList<ItemStack>();
		result.add(recipe.getResultItem());
		ingredients.setInputIngredients(recipe.getIngredients());
		ingredients.setOutputs(VanillaTypes.ITEM, result);
		
	}

	@Override
	public void setRecipe(IRecipeLayout recipeLayout, FlavoringRecipe recipe, IIngredients ingredients) {
		//TODO
		recipeLayout.getItemStacks().init(0, true, 11, 14);
		recipeLayout.getItemStacks().init(1, true, 29, 14);
		recipeLayout.getItemStacks().set(ingredients);
		
	}

	@Override
	public Component getTitle() {
		// TODO Auto-generated method stub
		return new TranslatableComponent("block.pepsimc.flavor_machine");
	}
	
	
}