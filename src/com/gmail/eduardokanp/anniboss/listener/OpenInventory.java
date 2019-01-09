package com.gmail.eduardokanp.anniboss.listener;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class OpenInventory implements Listener{	
	
	static ItemStack star = com.gmail.eduardokanp.anniboss.Main.star();
	static ItemStack helmet = com.gmail.eduardokanp.anniboss.Main.helmet();
	static ItemStack chestplate = com.gmail.eduardokanp.anniboss.Main.chestplate();
	static ItemStack leggings = com.gmail.eduardokanp.anniboss.Main.leggings();
	static ItemStack boots = com.gmail.eduardokanp.anniboss.Main.boots();
	static ItemStack sword = com.gmail.eduardokanp.anniboss.Main.sword();
	static ItemStack fSword = com.gmail.eduardokanp.anniboss.Main.fSword();
	static ItemStack bow = com.gmail.eduardokanp.anniboss.Main.bow();
	static ItemStack fPick = com.gmail.eduardokanp.anniboss.Main.fPick();
	static ItemStack hPick = com.gmail.eduardokanp.anniboss.Main.hPick();
	static ItemStack hPotion = com.gmail.eduardokanp.anniboss.Main.hPotion();
	
	static Inventory bInv = Bukkit.createInventory(null, 36, ChatColor.BLACK + "Boss Shop");
	
	static {
		// Row 1 //
		bInv.setItem(0, new ItemStack(Material.POTION, 1, (short) 16393));
		bInv.setItem(1, new ItemStack(Material.POTION, 1, (short) 16385));
		bInv.setItem(2, new ItemStack(Material.POTION, 1, (short) 16388));
		bInv.setItem(3, new ItemStack(Material.POTION, 1, (short) 16462));
		bInv.setItem(4, hPotion);
		// Row 2 //
		bInv.setItem(9, helmet);
		bInv.setItem(10, chestplate);
		bInv.setItem(11, leggings);
		bInv.setItem(12, boots);
		// Row 3 //
		//18
		bInv.setItem(18, sword);
		bInv.setItem(19, fSword);
		bInv.setItem(20, bow);
		
		
		// Row 4 //
		//27
		bInv.setItem(27, fPick);
		bInv.setItem(28, hPick);
		}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		ItemStack is = event.getCurrentItem();
		Inventory i = event.getInventory();
		if (i.getName().equals(bInv.getName())) {	
				if(!is.equals(air())) {
					event.setCancelled(true);
					p.getInventory().setItemInHand(is);
					p.closeInventory();
					} else if (is.equals(air())) {
						event.setCancelled(true);
					}
			}
	} 
	
	@EventHandler
	public void alDarClickEnEstrella(PlayerInteractEvent e) {
		if (e.getItem() != null) {
			if(e.getItem().equals(star)) {
				e.getPlayer().openInventory(bInv);
			}
		}

	}
	
	static ItemStack air() {
		ItemStack is = new ItemStack(Material.AIR);
		return is;
	}
	
}
