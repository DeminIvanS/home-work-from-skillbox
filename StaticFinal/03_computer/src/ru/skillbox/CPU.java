package ru.skillbox;

public class CPU {


    private final MakeCPU make;
    private final int frequency;
    private final int core;
    public int weightCPU; //в граммах


    public CPU(MakeCPU make, int frequency, int core, int weight){
        this.make = make;
        this.frequency = frequency;
        this.core = core;
        this.weightCPU = weight;
    }


    public MakeCPU getMake() {
        return make;
    }
    public int getFrequency() {
        return frequency;
    }
    public int getCore() {
        return core;
    }
    public int getWeightCPU() {
        return weightCPU;
    }
    public CPU setMake(MakeCPU make) {
        return new CPU(make, frequency, core, weightCPU);
    }
    public CPU setFrequency(int frequency)  {
        return new CPU(make, frequency, core, weightCPU);
    }
    public CPU setCore(int core) {
        return new CPU(make, frequency, core, weightCPU);
    }
    public CPU setWidthCPU(int weightCPU) {
        return new CPU(make, frequency, core, weightCPU);
    }

    public String toString(){
        return "\nПроизводитель: " + make +
                "\nЧастота: " + frequency + "Mhz" +
                "\nКоличество ядер: " + core +
                "\nВес: " + weightCPU + "г";
}



}
