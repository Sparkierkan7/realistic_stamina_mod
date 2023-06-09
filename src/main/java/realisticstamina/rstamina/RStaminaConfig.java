package realisticstamina.rstamina;

import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.data.Config;
import me.lortseam.completeconfig.data.ConfigOptions;

public class RStaminaConfig extends Config {

    @ConfigEntry(comment = "Maximum stamina of players. (Default: 64.0)")
    public double totalStamina = 64.0;
    @ConfigEntry(comment = "Energy gained every tick of resting. (Default: 0.002)")
    public double restingEnergyGainTick = 0.002;
    @ConfigEntry(comment = "If enabled you can gain energy by sitting on things. (Default: true)")
    public boolean enableResting = true;
    @ConfigEntry(comment = "Whether or not you rest when riding a horse, donkey or mule (Default: true)")
    public boolean restRidingHorse = true;
    @ConfigEntry(comment = "Whether or not you rest while moving your boat (Default: false)")
    public boolean restWhileBoatMoving = false;
    @ConfigEntry(comment = "Maximum energy that you can gain from resting. Resets when you sleep. (Default: 5.0)")
    public double maxRestingEnergyGain = 5.0;
    @ConfigEntry(comment = "X coordinate of stamina and energy hud. 0 is farthest left. (Default: 10)")
    public int hudX =  10;
    @ConfigEntry(comment = "Y coordinate of stamina and energy hud. 0 is top of the screen. (Default: 25)")
    public int hudY = 25;

    public RStaminaConfig() {
        super(ConfigOptions.mod(RStaminaMod.modid));
    }

}
