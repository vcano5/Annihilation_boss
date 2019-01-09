package com.gmail.eduardokanp.anniboss.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class RightClickOnStar implements Listener {
	
	static ItemStack star = com.gmail.eduardokanp.anniboss.Main.star();
	
	@EventHandler
	public void alDarClickEnEstrella(PlayerInteractEvent e) {
		if(e.getItem().equals(star)) {
			
		}
	}	
}
