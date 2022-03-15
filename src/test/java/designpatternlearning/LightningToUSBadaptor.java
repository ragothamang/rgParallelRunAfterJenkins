package designpatternlearning;

public class LightningToUSBadaptor implements MicroUSB{
	private final WirelessCharger wireless;
	
	public LightningToUSBadaptor(WirelessCharger wireless) {
		this.wireless = wireless;
	}

	@Override
	public String recharge() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Void userMicroUssb() {
		// TODO Auto-generated method stub
		return null;
	}

}
