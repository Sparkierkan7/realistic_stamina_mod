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
    @ConfigEntry(comment = "Whether or not block breaking uses your stamina. Using a tool with efficiency will still stop stamina from being used. (Default: true)")
    public boolean breakingBlocksUsesStamina = true;
    @ConfigEntry(comment = "When enabled, upon sleeping players whose energy is less than 85% will gain a default of 0.25 total stamina. And players whose energy is greater than 92% will lose a default of 0.25 total stamina if they already have more than the default total. (Default: true)")
    public boolean fitnessSystem = true;
    @ConfigEntry(comment = "Amount of stamina players gain or loose when the fitness system is enabled. (Default: 0.25)")
    public double fitnessStaminaChange = 0.25;
    @ConfigEntry(comment = "Maximum stamina players can reach with the fitness system. (Default: 128.0)")
    public double fitnessStaminaLimit = 128.0;
    @ConfigEntry(comment = "Enables or disables the energy system. (Default: true)")
    public boolean enableEnergySystem = true;
    @ConfigEntry(comment = "Upon sleeping if you have used less energy than this you will loose max stamina. (Default: 8.0)")
    public double fitnessUsedEnergyToKeep = 8.0;
    @ConfigEntry(comment = "Upon sleeping if you have used more energy than this you will gain max stamina. (Default: 15.0)")
    public double fitnessUsedEnergyToGain = 15.0;
    @ConfigEntry(comment = "Amount of stamina you lose per tick while running. (Default: 0.25)")
    public double staminaLossRate = 0.25;
    @ConfigEntry(comment = "Amount of stamina you gain per tick while not running. (Default: 0.1875)")
    public double staminaGainRate = 0.1875;
    @ConfigEntry(comment = "Amount of energy you lose per tick while running (Default: 0.004)")
    public double energyLossRate = 0.004;
    @ConfigEntry(comment = "Amount of stamina you lose when breaking solid blocks. (Default: 2.0)")
    public double blockBreakStaminaCost = 2.0;

    public RStaminaConfig() {
        super(ConfigOptions.mod(RStaminaMod.modid));
    }

}
