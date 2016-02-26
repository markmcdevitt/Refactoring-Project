package administrator;

public class NumberCheck{
	public boolean isNumeric(String str) {
		try {
			double d = Double.parseDouble(str);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
