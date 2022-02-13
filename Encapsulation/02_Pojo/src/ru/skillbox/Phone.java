package ru.skillbox;

    public class Phone {
        private String model;
        private String operationSystem;
        private int cpu;
        private int ram;

        public Phone(String model, int cpu) {
            this.model = model;

            this.cpu = cpu;

        }
        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getOperationSystem() {
            return operationSystem;
        }

        public void setOperationSystem(String system) {
            this.operationSystem = operationSystem;
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


