package com.gmail.eduardokanp.anniboss.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HastePotion implements Listener {

	ItemStack potion = com.gmail.eduardokanp.anniboss.Main.hPotion();
	
	@EventHandler
	public void onPotionDrink(PlayerItemConsumeEvent e) {
		if(e.getItem().equals(potion)) {
			e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 180, 2));
		}
	}
}
