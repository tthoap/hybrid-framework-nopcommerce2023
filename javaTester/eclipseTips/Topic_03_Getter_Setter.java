package eclipseTips;

public class Topic_03_Getter_Setter {

	private String carName;
	private String carType;
	private String carColor;
	private String carVendor;

	/**
	 * Get car name
	 * 
	 * @author tthoa
	 * 
	 * @return the carName
	 */
	public final String getCarName() {
		return carName;
	}

	/**
	 * @param carName the carName to set
	 */
	public final void setCarName(String carName) {
		this.carName = carName;
	}

	/**
	 * @return the carType
	 */
	public final String getCarType() {
		return carType;
	}

	/**
	 * @param carType the carType to set
	 */
	public final void setCarType(String carType) {
		this.carType = carType;
	}

	/**
	 * @return the carColor
	 */
	public final String getCarColor() {
		return carColor;
	}

	/**
	 * @param carColor the carColor to set
	 */
	public final void setCarColor(String carColor) {
		this.carColor = carColor;
	}

	/**
	 * @return the carVendor
	 */
	public final String getCarVendor() {
		return carVendor;
	}

	/**
	 * @param carVendor the carVendor to set
	 */
	public final void setCarVendor(String carVendor) {
		this.carVendor = carVendor;
	}

}
