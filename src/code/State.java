package code;

public class State {

    private int currentProsperity;
    private int currentFood;
    private int currentMaterials;
    private int currentEnergy;
    private int unitPriceFood;
    private int unitPriceMaterials;
    private int unitPriceEnergy;
    private int amountRequestFood;
    private int delayRequestFood;
    private int amountRequestMaterials;
    private int delayRequestMaterials;
    private int amountRequestEnergy;
    private int delayRequestEnergy;
    private int priceBUILD1;
    private int foodUseBUILD1;
    private int materialsUseBUILD1;
    private int energyUseBUILD1;
    private int prosperityBUILD1;
    private int priceBUILD2;
    private int foodUseBUILD2;
    private int materialsUseBUILD2;
    private int energyUseBUILD2;
    private int prosperityBUILD2;
    private int moneySoFar;
    private int currentFoodDelay;
    private int currentMaterialsDelay;
    private int currentEnergyDelay;

    public int getMoneySoFar() {
        return moneySoFar;
    }

    public void setMoneySoFar(int moneySoFar) {
        this.moneySoFar = moneySoFar;
    }

    public int getCurrentFoodDelay() {
        return currentFoodDelay;
    }

    public void setCurrentFoodDelay(int currentFoodDelay) {
        if(currentFoodDelay < 0)
            this.currentFoodDelay=0;
        else if(currentFoodDelay==0){
            this.currentFood=currentFood+amountRequestFood;
            this.currentFoodDelay=0;
        }
        else
            this.currentFoodDelay = currentFoodDelay;
    }

    public int getCurrentMaterialsDelay() {
        return currentMaterialsDelay;
    }

    public void setCurrentMaterialsDelay(int currentMaterialsDelay) {
        if(currentMaterialsDelay< 0)
            this.currentMaterialsDelay=0;
        else if(currentMaterialsDelay==0){
            this.currentMaterials=currentMaterials+amountRequestMaterials;
            this.currentMaterialsDelay=0;
        }
        else
            this.currentMaterialsDelay = currentMaterialsDelay;
    }

    public int getCurrentEnergyDelay() {
        return currentEnergyDelay;
    }

    public void setCurrentEnergyDelay(int currentEnergyDelay) {
        if(currentEnergyDelay< 0)
            this.currentEnergyDelay=0;
        else if(currentEnergyDelay==0){
            this.currentEnergy=currentEnergy+amountRequestEnergy;
            this.currentEnergyDelay=0;
        }
        else
            this.currentEnergyDelay = currentEnergyDelay;
    }

    public State(int currentProsperity, int currentFood, int currentMaterials, int currentEnergy, int unitPriceFood, int unitPriceMaterials, int unitPriceEnergy, int amountRequestFood, int delayRequestFood, int amountRequestMaterials, int delayRequestMaterials, int amountRequestEnergy, int delayRequestEnergy, int priceBUILD1, int foodUseBUILD1, int materialsUseBUILD1, int energyUseBUILD1, int prosperityBUILD1, int priceBUILD2, int foodUseBUILD2, int materialsUseBUILD2, int energyUseBUILD2, int prosperityBUILD2, int moneySoFar, int currentFoodDelay, int currentMaterialsDelay, int currentEnergyDelay) {
        this.currentProsperity = currentProsperity;
        this.currentFood = currentFood;
        this.currentMaterials = currentMaterials;
        this.currentEnergy = currentEnergy;
        this.unitPriceFood = unitPriceFood;
        this.unitPriceMaterials = unitPriceMaterials;
        this.unitPriceEnergy = unitPriceEnergy;
        this.amountRequestFood = amountRequestFood;
        this.delayRequestFood = delayRequestFood;
        this.amountRequestMaterials = amountRequestMaterials;
        this.delayRequestMaterials = delayRequestMaterials;
        this.amountRequestEnergy = amountRequestEnergy;
        this.delayRequestEnergy = delayRequestEnergy;
        this.priceBUILD1 = priceBUILD1;
        this.foodUseBUILD1 = foodUseBUILD1;
        this.materialsUseBUILD1 = materialsUseBUILD1;
        this.energyUseBUILD1 = energyUseBUILD1;
        this.prosperityBUILD1 = prosperityBUILD1;
        this.priceBUILD2 = priceBUILD2;
        this.foodUseBUILD2 = foodUseBUILD2;
        this.materialsUseBUILD2 = materialsUseBUILD2;
        this.energyUseBUILD2 = energyUseBUILD2;
        this.prosperityBUILD2 = prosperityBUILD2;
        this.moneySoFar=moneySoFar;
        this.currentFoodDelay=currentFoodDelay;
        this.currentMaterialsDelay=currentMaterialsDelay;
        this.currentEnergyDelay=currentEnergyDelay;
    }

    public int getCurrentProsperity() {
        return currentProsperity;
    }

    public void setCurrentProsperity(int currentProsperity) {
        this.currentProsperity = currentProsperity;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    public void setCurrentFood(int currentFood) {
        if(currentFood>50){
            this.currentFood = 50;
        }
        else{
            this.currentFood = currentFood;
        }
    }

    public int getCurrentMaterials() {
        return currentMaterials;
    }

    public void setCurrentMaterials(int currentMaterials) {
        if(currentMaterials>50){
            this.currentMaterials = 50;
        }
        else{
            this.currentMaterials = currentMaterials;
        }
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    public void setCurrentEnergy(int currentEnergy) {
        if(currentEnergy>50){
            this.currentEnergy = 50;
        }
        else{
            this.currentEnergy = currentEnergy;
        }

    }

    public int getUnitPriceFood() {
        return unitPriceFood;
    }

    public void setUnitPriceFood(int unitPriceFood) {
        this.unitPriceFood = unitPriceFood;
    }

    public int getUnitPriceMaterials() {
        return unitPriceMaterials;
    }

    public void setUnitPriceMaterials(int unitPriceMaterials) {
        this.unitPriceMaterials = unitPriceMaterials;
    }

    public int getUnitPriceEnergy() {
        return unitPriceEnergy;
    }

    public void setUnitPriceEnergy(int unitPriceEnergy) {
        this.unitPriceEnergy = unitPriceEnergy;
    }

    public int getAmountRequestFood() {
        return amountRequestFood;
    }

    public void setAmountRequestFood(int amountRequestFood) {
        this.amountRequestFood = amountRequestFood;
    }

    public int getDelayRequestFood() {
        return delayRequestFood;
    }

    public void setDelayRequestFood(int delayRequestFood) {
        this.delayRequestFood = delayRequestFood;
    }

    public int getAmountRequestMaterials() {
        return amountRequestMaterials;
    }

    public void setAmountRequestMaterials(int amountRequestMaterials) {
        this.amountRequestMaterials = amountRequestMaterials;
    }

    public int getDelayRequestMaterials() {
        return delayRequestMaterials;
    }

    public void setDelayRequestMaterials(int delayRequestMaterials) {
        this.delayRequestMaterials = delayRequestMaterials;
    }

    public int getAmountRequestEnergy() {
        return amountRequestEnergy;
    }

    public void setAmountRequestEnergy(int amountRequestEnergy) {
        this.amountRequestEnergy = amountRequestEnergy;
    }

    public int getDelayRequestEnergy() {
        return delayRequestEnergy;
    }

    public void setDelayRequestEnergy(int delayRequestEnergy) {
        this.delayRequestEnergy = delayRequestEnergy;
    }

    public int getPriceBUILD1() {
        return priceBUILD1;
    }

    public void setPriceBUILD1(int priceBUILD1) {
        this.priceBUILD1 = priceBUILD1;
    }

    public int getFoodUseBUILD1() {
        return foodUseBUILD1;
    }

    public void setFoodUseBUILD1(int foodUseBUILD1) {
        this.foodUseBUILD1 = foodUseBUILD1;
    }

    public int getMaterialsUseBUILD1() {
        return materialsUseBUILD1;
    }

    public void setMaterialsUseBUILD1(int materialsUseBUILD1) {
        this.materialsUseBUILD1 = materialsUseBUILD1;
    }

    public int getEnergyUseBUILD1() {
        return energyUseBUILD1;
    }

    public void setEnergyUseBUILD1(int energyUseBUILD1) {
        this.energyUseBUILD1 = energyUseBUILD1;
    }

    public int getProsperityBUILD1() {
        return prosperityBUILD1;
    }

    public void setProsperityBUILD1(int prosperityBUILD1) {
        this.prosperityBUILD1 = prosperityBUILD1;
    }

    public int getPriceBUILD2() {
        return priceBUILD2;
    }

    public void setPriceBUILD2(int priceBUILD2) {
        this.priceBUILD2 = priceBUILD2;
    }

    public int getFoodUseBUILD2() {
        return foodUseBUILD2;
    }

    public void setFoodUseBUILD2(int foodUseBUILD2) {
        this.foodUseBUILD2 = foodUseBUILD2;
    }

    public int getMaterialsUseBUILD2() {
        return materialsUseBUILD2;
    }

    public void setMaterialsUseBUILD2(int materialsUseBUILD2) {
        this.materialsUseBUILD2 = materialsUseBUILD2;
    }

    public int getEnergyUseBUILD2() {
        return energyUseBUILD2;
    }

    public void setEnergyUseBUILD2(int energyUseBUILD2) {
        this.energyUseBUILD2 = energyUseBUILD2;
    }

    public int getProsperityBUILD2() {
        return prosperityBUILD2;
    }

    public void setProsperityBUILD2(int prosperityBUILD2) {
        this.prosperityBUILD2 = prosperityBUILD2;
    }

    @Override
    public String toString(){
        return "Prosperity: "+currentProsperity+" Food: "+currentFood+" Materials: "+currentMaterials+" Energy: "+currentEnergy + " Current Food Delay: "+currentFoodDelay+" Current Materials Delay: "+currentMaterialsDelay+" Current Energy Delay: "+currentEnergyDelay;
    }
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof State){
            State state=(State)obj;
            return state.getCurrentProsperity() == this.getCurrentProsperity() &&
                    state.getCurrentFood() == this.getCurrentFood() &&
                    state.getCurrentMaterials() == this.getCurrentMaterials() &&
                    state.getCurrentEnergy() == this.getCurrentEnergy()
                  &&  state.getCurrentFoodDelay() == -1 &&
                    state.getCurrentMaterialsDelay() == -1 &&
                    state.getCurrentEnergyDelay() == -1;
        }
        return false;
    }
}
