package wiggo5.weaponsmod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import wiggo5.weaponsmod.item.ItemsharpIronSword;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = "wm", name = "The Weapons Mod", version = "1.0")
public class WeaponsMod 
{
	public static Item itemSharpSword;
	public static Item itemSharpeningStone;
	
	public static Item sharpIronSword;
	
	public static final Item.ToolMaterial sharpIronSwordMaterial = EnumHelper.addToolMaterial("sharpIronSwordMaterial", 4, 2500, 20.0F, 5.5F, 30);
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//item/block init and registering
		//config handling
		itemSharpSword = new ItemSharpSword().setUnlocalizedName("ItemSharpSword").setTextureName("wm:itemSharpSword").setCreativeTab(tabWeaponsMod);
		GameRegistry.registerItem(itemSharpSword, itemSharpSword.getUnlocalizedName().substring(5));
		
		itemSharpeningStone = new ItemSharpeningStone().setUnlocalizedName("ItemSharpeningStone").setTextureName("wm:itemSharpeningStones").setCreativeTab(tabWeaponsMod);
		GameRegistry.registerItem(itemSharpeningStone, itemSharpeningStone.getUnlocalizedName().substring(5));
		
		sharpIronSword = new ItemsharpIronSword(sharpIronSwordMaterial).setUnlocalizedName("sharpIronSword").setTextureName("wm:itemSharpSword").setCreativeTab(tabWeaponsMod);
		GameRegistry.registerItem(sharpIronSword, sharpIronSword.getUnlocalizedName().substring(5));

	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		//proxy, tileEntity, entity, GUI, and packet registering
		GameRegistry.addRecipe(new ItemStack(itemSharpSword), new Object[]{" s ", "bS ","   ", 's', Items.stone_sword, 'b', Items.water_bucket, 'S', WeaponsMod.itemSharpeningStone});
		GameRegistry.addRecipe(new ItemStack(itemSharpeningStone), new Object[]{" s ", " g "," c ", 's', Blocks.sand, 'g', Blocks.gravel, 'c', Blocks.clay});
		GameRegistry.addRecipe(new ItemStack(sharpIronSword), new Object[]{" s ", "bS ","   ", 's', Items.iron_sword, 'b', Items.water_bucket, 'S', WeaponsMod.itemSharpeningStone});

	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	public static CreativeTabs tabWeaponsMod = new CreativeTabs("tabWeaponsMod") 
	{
		@Override
		public Item getTabIconItem()
		{
			return new ItemStack(itemSharpeningStone).getItem();
		}
	};
	
}
