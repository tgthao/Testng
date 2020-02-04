package FactoryPattern;

public class CarFactory_01 {
	public void viewCarVersion(String carName) {
		if(carName.equalsIgnoreCase("Honda")) {
			HondaCar honda = new HondaCar();
			honda.ViewCarFactory();
			honda.viewCarFactoryName();
		} else if (carName.equalsIgnoreCase("Ford")) {
			FordCar fordCar = new FordCar();
			fordCar.viewFordAddress();
			fordCar.viewCarFactoryName();
		}
	}
}
