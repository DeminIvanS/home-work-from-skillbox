package ru.skillbox;

    public class Phone {
        private String model;
        private String system;
        private int cpu;
        private int ram;

        public Phone(String model, int cpu) {
            this.model = model;
            this.system = system;
            this.cpu = cpu;
            this.ram = ram;
        }
        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getSystem() {
            return system;
        }

        public void setSystem(String system) {
            this.system = system;
        }

        public int getCpu() {
            return cpu;
        }

        public void setCpu(int cpu) {
            this.cpu = cpu;
        }

        public int getRam() {
            return ram;
        }

        public void setRam(int ram) {
            this.ram = ram;
        }

    }


